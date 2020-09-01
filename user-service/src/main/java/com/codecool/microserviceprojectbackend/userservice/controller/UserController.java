package com.codecool.microserviceprojectbackend.userservice.controller;

import com.codecool.microserviceprojectbackend.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(path = "/signin",method = POST)
    public String signinUser(@RequestBody String userCredentials) {

        return "helo";
    }

    @RequestMapping(path = "/registration",method = POST)
    public String registerUser(@RequestBody String userCredentials) {

        return "helo";
    }

}
