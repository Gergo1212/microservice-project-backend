package com.codecool.microserviceprojectbackend.productservice.dao;

import com.codecool.microserviceprojectbackend.productservice.model.Product;
import com.codecool.microserviceprojectbackend.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductDaoDB implements ProductDao {

    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        productRepository.saveAndFlush(product);
        return product;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        productRepository.deleteById(id);
        return product;
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productRepository.findAllByNameContaining(name);
    }

}
