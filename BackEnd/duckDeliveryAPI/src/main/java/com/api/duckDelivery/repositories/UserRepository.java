package com.api.duckDelivery.repositories;

import com.api.duckDelivery.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;




@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    boolean existsByEmail(String emailUser);

    UserModel findByEmail(String emailUser);

    //Query utilizada para buscar a conta no banco
    @Query(value = "select * from tb_user where email = :email and senha = :senha", nativeQuery = true)
    UserModel UserLogin(String email, String senha);
}
