package com.api.duckDelivery.controllers;

import com.api.duckDelivery.dtos.StoreDto;
import com.api.duckDelivery.dtos.UserDto;
import com.api.duckDelivery.models.StoreModel;
import com.api.duckDelivery.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/")
public class StoreController {

    private final com.api.duckDelivery.services.StoreService storeService;

    public StoreController(com.api.duckDelivery.services.StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/storeRegister")
    public ResponseEntity<Object> storeRegister(@RequestBody @Valid StoreDto storeDto){
        var storeModel = new StoreModel();
        BeanUtils.copyProperties(storeDto, storeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.StoreRegister(storeModel));
    }
}
