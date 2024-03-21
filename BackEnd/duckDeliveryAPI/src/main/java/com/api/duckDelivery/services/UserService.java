package com.api.duckDelivery.services;


import com.api.duckDelivery.models.UserModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


import org.springframework.stereotype.Service;
import com.api.duckDelivery.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository ur) {
        this.userRepository = ur;
    }

    //Método para cadastro de usuário
    @Transactional
    public UserModel UserRegister(@RequestBody @Valid UserModel userModel){
        return userRepository.save(userModel);
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
    
}
