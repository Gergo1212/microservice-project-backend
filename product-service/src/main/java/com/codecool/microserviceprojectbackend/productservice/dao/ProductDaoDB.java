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
        log.info("Get all products");
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        log.info("Get product by productId: " + productId);
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        productRepository.saveAndFlush(product);
        log.info("added product: " + product);
        return product;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        productRepository.deleteById(id);
        log.info("product deleted: " + product);
        return product;
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        log.info("search product by name: " + name);
        return productRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        Product productToUpdate = productRepository.findById(productId).orElse(null);

        if (productToUpdate != null) {
            productToUpdate.setName(updatedProduct.getName());
            productToUpdate.setDescription(updatedProduct.getDescription());
            productToUpdate.setCategory(updatedProduct.getCategory());
            productToUpdate.setPrice(updatedProduct.getPrice());
            productToUpdate.setImageUrl(updatedProduct.getImageUrl());

            productRepository.saveAndFlush(productToUpdate);

            log.info("updated product: " + productToUpdate);
        } else {
            log.info("product not found with id: " + productId);
        }
        return productToUpdate;
    }

}
