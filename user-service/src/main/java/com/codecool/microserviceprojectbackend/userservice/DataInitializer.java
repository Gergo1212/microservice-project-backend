package com.codecool.microserviceprojectbackend.userservice;

import com.codecool.microserviceprojectbackend.userservice.entity.UserEntity;
import com.codecool.microserviceprojectbackend.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    DataInitializer() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity user = UserEntity.builder()
                .username("dinnye")
                .password(passwordEncoder.encode("dinnye"))
                .build();

        userRepository.save(user);

        UserEntity admin = UserEntity.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .build();

        userRepository.save(admin);
    }
}
