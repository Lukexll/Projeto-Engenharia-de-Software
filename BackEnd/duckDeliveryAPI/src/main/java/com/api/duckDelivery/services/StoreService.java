package com.api.duckDelivery.services;

import com.api.duckDelivery.models.StoreModel;
import com.api.duckDelivery.models.UserModel;
import com.api.duckDelivery.repositories.StoreRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class StoreService {

    private  final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public StoreModel StoreRegister(@RequestBody @Valid StoreModel storeModel) {
        return storeRepository.save(storeModel);
    }

    public boolean existByCNPJ (String CNPJ){
        return storeRepository.existsByCNPJ(CNPJ);
    }

    public boolean existsByEmail(String email) {
        return storeRepository.existsByEmail(email);
    }

    public UserModel StoreLogin(String emailUser, String senhaUser){
        return storeRepository.StoreLogin(emailUser, senhaUser);
    }

    public HttpSession findByEmail(@RequestBody @Valid String email) {
        return storeRepository.findByEmail(email);
    }

    public void delete(StoreModel storeModel) {
        storeRepository.delete(storeModel);
    }

    public Optional<StoreModel> findById(UUID id) {
        return storeRepository.findById(id);
    }
}
