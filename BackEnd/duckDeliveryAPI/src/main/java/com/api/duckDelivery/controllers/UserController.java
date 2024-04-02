package com.api.duckDelivery.controllers;

import com.api.duckDelivery.dtos.UserDto;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.duckDelivery.models.LoginModel;
import com.api.duckDelivery.models.ResponseModel;
import com.api.duckDelivery.models.UserModel;
import com.api.duckDelivery.services.CookieService;
import com.api.duckDelivery.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;







@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/login")

public class UserController {
    private final com.api.duckDelivery.services.UserService userService;
    

    public UserController(UserService us, UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public ResponseModel responseModel;

    @PostMapping("/userRegister")
    public ResponseEntity<Object> userRegister(@RequestBody @Valid UserDto userDto){
        if (userService.existsByEmail(userDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email existente.");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.UserRegister(userModel));

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
    
    

}
