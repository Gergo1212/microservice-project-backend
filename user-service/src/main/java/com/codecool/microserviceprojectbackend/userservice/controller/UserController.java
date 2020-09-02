package com.codecool.microserviceprojectbackend.userservice.controller;

import com.codecool.microserviceprojectbackend.userservice.entity.UserEntity;
import com.codecool.microserviceprojectbackend.userservice.model.UserModel;
import com.codecool.microserviceprojectbackend.userservice.repository.UserRepository;
import com.codecool.microserviceprojectbackend.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    /*

    @RequestMapping(path = "/signin",method = POST)
    public String signinUser(@RequestBody String userCredentials) {

        return "helo";
    }
    
     */

    @RequestMapping(path = "/registration",method = POST)
    public boolean registerUser(@RequestBody UserModel userCredentials) {
        return userService.registerUser(userCredentials);
    }

    @GetMapping(path = "/getUser/{username}")
    public UserEntity getUser(@PathVariable String username) {
        System.out.println("ittevan");
        UserEntity byUsername = userRepository.findByUsername(username);
        System.out.println("byUsername " + byUsername);
        return byUsername;
    }

}
