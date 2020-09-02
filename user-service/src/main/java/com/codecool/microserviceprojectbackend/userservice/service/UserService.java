package com.codecool.microserviceprojectbackend.userservice.service;

import com.codecool.microserviceprojectbackend.userservice.entity.UserEntity;
import com.codecool.microserviceprojectbackend.userservice.model.UserModel;
import com.codecool.microserviceprojectbackend.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    UserService() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    public boolean registerUser(UserModel userCredentials) {
        boolean existsByUsername = userRepository.existsByUsername(userCredentials.getUsername());
        if(!existsByUsername) {
            userRepository.save(UserEntity.builder().username(userCredentials.getUsername()).password(passwordEncoder.encode(userCredentials.getPassword())).build());
            return true;
        }
        return false;
    }
}
