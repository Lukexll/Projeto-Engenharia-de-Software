package com.api.duckDelivery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.duckDelivery.models.ResponseModel;
import com.api.duckDelivery.models.UserModel;
import com.api.duckDelivery.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    @Autowired
    private ResponseModel rm;


    //Método para cadastro de usuário
    public ResponseEntity<?> UserRegister(UserModel um){

        for (int i = 1; i< ur.count(); i++){
            if (um.getEmail() == ur.findAll().get(i).getEmail()) {
                rm.setMensagem(false);
                return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
            }
        }
        rm.setMensagem(true);
        ur.save(um);
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.CREATED);

    }
}
