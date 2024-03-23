package com.api.duckDelivery.controllers;

import com.api.duckDelivery.dtos.UserDto;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;


import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.duckDelivery.models.LoginModel;
import com.api.duckDelivery.models.UserModel;
import com.api.duckDelivery.services.CookieService;
import com.api.duckDelivery.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;







@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/login")

public class UserController {
    private final com.api.duckDelivery.services.UserService userService;

    public UserController(UserService us, UserService userService) {
        this.userService = userService;
    }


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
    public ResponseEntity<Object> UserLogin(@RequestBody @Valid LoginModel loginParam, HttpServletResponse response, HttpServletRequest requestCookie) {
        if(!userService.existsByEmail(loginParam.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email não cadastrado.");
        }
        if(userService.UserLogin(loginParam.getEmail(), loginParam.getSenha()) == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Senha incorreta.");
        }
        CookieService.setCookie(response, "userId", String.valueOf(userService.findByEmail(loginParam.getEmail()).getId()), 10);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login efetuado.");
            
    } 
    
    

}
