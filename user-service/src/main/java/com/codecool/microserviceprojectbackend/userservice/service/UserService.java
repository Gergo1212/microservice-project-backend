package com.codecool.microserviceprojectbackend.userservice.service;

import com.codecool.microserviceprojectbackend.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


}
