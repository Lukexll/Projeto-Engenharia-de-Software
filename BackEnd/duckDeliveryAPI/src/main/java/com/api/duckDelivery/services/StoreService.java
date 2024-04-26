package com.api.duckDelivery.services;

import com.api.duckDelivery.models.StoreModel;
import com.api.duckDelivery.repositories.StoreRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class StoreService {

    private static StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        StoreService.storeRepository = storeRepository;
    }

    public static StoreModel save(StoreModel storeModel) {
        return storeRepository.save(storeModel);
    }

    public static Optional<StoreModel> findById(UUID id) {
        return storeRepository.findById(id);
    }

    public StoreModel saveStore(@RequestBody @Valid StoreModel storeModel) {
        return storeRepository.save(storeModel);
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
