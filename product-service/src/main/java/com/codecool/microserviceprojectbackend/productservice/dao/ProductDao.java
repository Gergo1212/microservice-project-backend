package com.codecool.microserviceprojectbackend.productservice.dao;

import com.codecool.microserviceprojectbackend.productservice.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();

    Product getProduct(Long id);

    Product addProduct(Product product);

    Product deleteProduct(Long id);

    List<Product> searchProductsByName(String name);

    Product updateProduct(Long productId, Product product);
}
