package com.api.duckDelivery.repositories;

import com.api.duckDelivery.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
