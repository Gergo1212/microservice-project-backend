package com.codecool.microserviceprojectbackend.productservice.repository;

import com.codecool.microserviceprojectbackend.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByNameContainingIgnoreCase(String name);

}
