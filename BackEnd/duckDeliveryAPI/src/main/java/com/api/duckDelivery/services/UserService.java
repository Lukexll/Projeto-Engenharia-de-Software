package com.api.duckDelivery.services;


import com.api.duckDelivery.models.UserModel;
import jakarta.validation.Valid;


import org.springframework.stereotype.Service;
import com.api.duckDelivery.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository ur) {
        this.userRepository = ur;
    }

    public boolean existsByEmail(String emailUser){
        return userRepository.existsByEmail(emailUser);
    }

    public UserModel findByEmail(@RequestBody @Valid String emailUser){
        return userRepository.findByEmail(emailUser);
    }

    //Método para retornar a conta a ser logada.
    public UserModel UserLogin(String emailUser, String senhaUser){
        return userRepository.UserLogin(emailUser, senhaUser);
    }

    public Optional<UserModel> findById(UUID id) {
        return userRepository.findById(id);
    }

    public UserModel saveUser(UserModel userModel){
        return userRepository.save(userModel);
    }

    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }
}
