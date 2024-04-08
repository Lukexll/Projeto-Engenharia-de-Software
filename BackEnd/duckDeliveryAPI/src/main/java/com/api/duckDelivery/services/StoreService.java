package com.api.duckDelivery.services;

import com.api.duckDelivery.models.StoreModel;
import com.api.duckDelivery.repositories.StoreRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StoreService {

    private  final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public StoreModel saveStore(@RequestBody @Valid StoreModel storeModel) {
        return storeRepository.save(storeModel);
    }

    public boolean existByCNPJ (String CNPJ){
        return storeRepository.existsByCNPJ(CNPJ);
    }

    public  boolean existByStoreName(String storeName){
        return storeRepository.existsByStoreName(storeName);
    }

    public void delete(StoreModel storeModel) {
        storeRepository.delete(storeModel);
    }

    public StoreModel findByStoreName(String storeName){
        return storeRepository.findByStoreName(storeName);
    }
}
