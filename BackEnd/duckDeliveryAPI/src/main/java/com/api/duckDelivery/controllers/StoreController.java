package com.api.duckDelivery.controllers;

import com.api.duckDelivery.dtos.StoreDto;
import com.api.duckDelivery.models.ResponseModel;
import com.api.duckDelivery.models.StoreModel;
import com.api.duckDelivery.repositories.StoreRepository;
import com.api.duckDelivery.services.CookieService;
import com.api.duckDelivery.services.StoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;
    private final ResponseModel responseModel;
    private final StoreRepository storeRepository;

    public StoreController(StoreService storeService, ResponseModel responseModel, StoreRepository storeRepository) {
        this.storeService = storeService;
        this.responseModel = responseModel;
        this.storeRepository = storeRepository;
    }

    @PostMapping("/storeRegister")
    public ResponseEntity<ResponseModel> storeRegister(@RequestBody @Valid StoreDto storeDto, HttpServletRequest request) {
        String userId = CookieService.getCookie(request, "userId");

        if (storeService.existByStoreName(storeDto.getStoreName())) {
            responseModel.setMessage("Nome existente");
            return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
        }

        var storeModel = new StoreModel();
        BeanUtils.copyProperties(storeDto, storeModel);
        storeModel.setID_User(userId);
        storeService.saveStore(storeModel);
        responseModel.setMessage("Cadastrado.");
        return new ResponseEntity<>(responseModel, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/storeDelete/{storeName}")
    public ResponseEntity<?> StoreDelete(@PathVariable(value = "storeName") String storeName) {
        Optional<StoreModel> storeModelOptional = Optional.ofNullable(storeService.findByStoreName(storeName));
        if (storeModelOptional.isEmpty()) {
            responseModel.setMessage("Loja não encontrada.");
            return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
        }

        storeService.delete(storeModelOptional.get());
        responseModel.setMessage("Loja deletada");
        return new ResponseEntity<>(responseModel, HttpStatus.ACCEPTED);
    }

    @GetMapping("/storeGet/{storeName}")
    public ResponseEntity<?> getOneStore(@PathVariable @Valid String storeName) {
        StoreModel storeModelOptional = storeService.findByStoreName(storeName);
        if (storeModelOptional == null) {
            responseModel.setMessage("Loja não encontrada.");
            return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(storeModelOptional, HttpStatus.ACCEPTED);
    }

    @GetMapping("/storeGetAll")
    public ResponseEntity<List<StoreModel>> getAllStores(HttpServletRequest request) {
        String userId = CookieService.getCookie(request, "userId");
        return new ResponseEntity<>(storeRepository.findAllStore(userId), HttpStatus.ACCEPTED);
    }

}
