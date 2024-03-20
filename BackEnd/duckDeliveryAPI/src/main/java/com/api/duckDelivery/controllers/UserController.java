package com.api.duckDelivery.controllers;

import com.api.duckDelivery.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.duckDelivery.models.UserModel;
import com.api.duckDelivery.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/duck-delivery")
public class UserController {
    private final com.api.duckDelivery.services.UserService userService;

    public UserController(UserService us, UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> userRegister(@RequestBody @Valid UserDto userDto){
        if (userService.existsByEmail(userDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email existente.");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.UserRegister(userModel));
    }
    

}
