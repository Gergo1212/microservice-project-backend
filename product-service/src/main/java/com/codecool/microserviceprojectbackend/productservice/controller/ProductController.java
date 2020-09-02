package com.codecool.microserviceprojectbackend.productservice.controller;

import com.codecool.microserviceprojectbackend.productservice.dao.ProductDao;
import com.codecool.microserviceprojectbackend.productservice.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductDao productDao;

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return productDao.getProduct(productId);
    }

    @PostMapping("")
    public Product addProduct(@RequestBody Product product) {
        return productDao.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productDao.deleteProduct(id);
    }

    @GetMapping("/search/findByName")
    public List<Product> searchProductsByName(@RequestParam String name) {
        return productDao.searchProductsByName(name);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        return productDao.updateProduct(productId, product);
    }

}
