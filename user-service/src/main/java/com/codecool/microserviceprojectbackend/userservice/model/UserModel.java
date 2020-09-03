package com.codecool.microserviceprojectbackend.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private Long id;

    private String username;


    private String password;

    private List<String> roles = new ArrayList<>();
}
