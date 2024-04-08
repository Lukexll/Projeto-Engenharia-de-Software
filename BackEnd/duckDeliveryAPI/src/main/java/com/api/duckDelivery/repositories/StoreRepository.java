package com.api.duckDelivery.repositories;

import com.api.duckDelivery.models.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoreRepository extends JpaRepository<StoreModel, UUID> {
    boolean existsByCNPJ(String CNPJ);
    boolean existsByStoreName(String storeName);
    StoreModel findByStoreName(String storeName);


}
