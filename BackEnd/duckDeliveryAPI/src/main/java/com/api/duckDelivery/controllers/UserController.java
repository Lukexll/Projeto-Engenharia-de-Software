package com.api.duckDelivery.controllers;

import com.api.duckDelivery.dtos.UserDto;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.duckDelivery.models.LoginModel;
import com.api.duckDelivery.models.ResponseModel;
import com.api.duckDelivery.models.UserModel;
import com.api.duckDelivery.services.CookieService;
import com.api.duckDelivery.services.UserService;
import java.util.Optional;
import java.util.UUID;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/login")

public class UserController {
    private final com.api.duckDelivery.services.UserService userService;
    public final ResponseModel responseModel;

    public UserController(UserService us, UserService userService, ResponseModel responseModel) {
        this.userService = userService;
        this.responseModel = responseModel;
    }

    @PostMapping("/userRegister")
    public ResponseEntity<ResponseModel> userRegister(@RequestBody @Valid UserDto userDto, HttpServletRequest request) {
        String userId = CookieService.getCookie(request, "userId");

        if (userService.existsByEmail(userDto.getEmail())){
            responseModel.setMessage("Conflict: Email existente.");
            return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.BAD_REQUEST);
        }

        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        responseModel.setMessage("Cadastrado.");
        return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.ACCEPTED);
    }

    
    @PostMapping("/userLogin")
    public ResponseEntity<?> UserLogin(@RequestBody @Valid LoginModel loginParam, HttpServletResponse response, HttpServletRequest requestCookie) {
        if(!userService.existsByEmail(loginParam.getEmail())){
            responseModel.setMessage("Email não cadastrado.");
            return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.BAD_REQUEST);
        }
        if(userService.UserLogin(loginParam.getEmail(), loginParam.getSenha()) == null){
            responseModel.setMessage("Senha incorreta.");
            return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.BAD_REQUEST);
        }
        CookieService.setCookie(response, "userId", String.valueOf(userService.findByEmail(loginParam.getEmail()).getId()), 10);
        responseModel.setMessage("Login efetuado.");
        return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.ACCEPTED);
            
    }

    @DeleteMapping("/userDelete")
    public ResponseEntity<?> UserDelete(@PathVariable (value = "id") UUID id, HttpServletRequest request) {
        String userId = CookieService.getCookie(request, "userId");
        if (userId.isEmpty()) {
            responseModel.setMessage("Não autorizado: O usuário não está logado.");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.UNAUTHORIZED);
        }
        Optional<UserModel> userModelOptional = userService.findById(id);
        if (userModelOptional.isEmpty()) {
            responseModel.setMessage("Usuário não encontrado.");
            return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.BAD_REQUEST);
        }

        userService.delete(userModelOptional.get());
        responseModel.setMessage("Usuário deletado");
        return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.ACCEPTED);
    }



}
