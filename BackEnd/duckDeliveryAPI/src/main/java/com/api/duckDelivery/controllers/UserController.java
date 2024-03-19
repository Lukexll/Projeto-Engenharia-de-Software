package com.api.duckDelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserService us;

    @PostMapping("/UserRegister")
    public ResponseEntity<?> userRegister(@RequestBody UserModel um){

        return us.UserRegister(um);
    }
    

}
