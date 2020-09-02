package com.codecool.microserviceprojectbackend.userservice.repository;

import com.codecool.microserviceprojectbackend.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUsername(String username);

    UserEntity findByUsername(String username);

}
