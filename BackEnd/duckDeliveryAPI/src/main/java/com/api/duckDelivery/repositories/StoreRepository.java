package com.api.duckDelivery.repositories;

import com.api.duckDelivery.models.StoreModel;
import com.api.duckDelivery.models.UserModel;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreRepository extends JpaRepository<StoreModel, UUID> {
    boolean existsByCNPJ(String CNPJ);
    boolean existsByEmail(String email);
    @Query(value = "select * from tb_user where email = :email and senha = :senha", nativeQuery = true)
    UserModel StoreLogin(String emailUser, String senhaUser);

    HttpSession findByEmail(String email);
}
