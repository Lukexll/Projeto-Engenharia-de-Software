package com.api.duckDelivery.controllers;

import com.api.duckDelivery.dtos.StoreDto;
import com.api.duckDelivery.models.LoginModel;
import com.api.duckDelivery.models.ResponseModel;
import com.api.duckDelivery.models.StoreModel;
import com.api.duckDelivery.services.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/")
public class StoreController {

    private final com.api.duckDelivery.services.StoreService storeService;
    private final ResponseModel responseModel;

    public StoreController(com.api.duckDelivery.services.StoreService storeService, ResponseModel responseModel) {
        this.storeService = storeService;
        this.responseModel = responseModel;
    }

    @PostMapping("/storeRegister")
    public ResponseEntity<ResponseModel> storeRegister(@RequestBody @Valid StoreDto storeDto, HttpServletRequest request){
        String storeId = CookieService.getCookie(request, "storeId");

        if (storeService.existByCNPJ(storeDto.getCNPJ())){
            responseModel.setMessage("CNPJ existente");
            return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
        }

        var storeModel = new StoreModel();
        BeanUtils.copyProperties(storeDto, storeModel);
        responseModel.setMessage("Cadastrado.");
        return new ResponseEntity<>(responseModel,HttpStatus.ACCEPTED);
    }

    @PostMapping("/storeLogin")
    public ResponseEntity<?> StoreLogin(@RequestBody @Valid LoginModel loginParam, HttpServletResponse response, HttpServletRequest requestCookie) {
        if(!storeService.existsByEmail(loginParam.getEmail())){
            responseModel.setMessage("Email não cadastrado.");
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
        if(storeService.StoreLogin(loginParam.getEmail(), loginParam.getSenha()) == null){
            responseModel.setMessage("Senha incorreta.");
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
        CookieService.setCookie(response, "storeId", String.valueOf(storeService.findByEmail(loginParam.getEmail()).getId()), 10);
        responseModel.setMessage("Login efetuado.");
        return new ResponseEntity<>(responseModel,HttpStatus.ACCEPTED);

    }

    @GetMapping("/storeGet/{id}")
    public ResponseEntity<?> getOneStore(@PathVariable(value = "id") UUID id){
        Optional<StoreModel> storeModelOptional = storeService.findById(id);
        if (storeModelOptional.isEmpty()) {
            responseModel.setMessage("Loja não encontrada.");
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

        responseModel.setMessage("Loja encontrada.");

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("storeModel", storeModelOptional.get());
        responseMap.put("responseModel", responseModel);

        return new ResponseEntity<>(responseMap, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/storeDelete")
    public ResponseEntity<?> StoreDelete(@PathVariable (value = "id") UUID id, HttpServletRequest request) {
        String storeId = CookieService.getCookie(request, "storeId");
        if (storeId.isEmpty()) {
            responseModel.setMessage("Não autorizado: O loja não está logado.");
            return new ResponseEntity<>(responseModel, HttpStatus.UNAUTHORIZED);
        }
        Optional<StoreModel> storeModelOptional = storeService.findById(id);
        if (storeModelOptional.isEmpty()) {
            responseModel.setMessage("Loja não encontrado.");
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

        storeService.delete(storeModelOptional.get());
        responseModel.setMessage("Loja deletado");
        return new ResponseEntity<>(responseModel,HttpStatus.ACCEPTED);
    }

}
