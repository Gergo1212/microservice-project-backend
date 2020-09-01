package com.codecool.microserviceprojectbackend.productservice.controller;

import com.codecool.microserviceprojectbackend.productservice.dao.ProductDao;
import com.codecool.microserviceprojectbackend.productservice.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class ProductController {

    private ProductDao productDao;

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productDao.getProduct(id);
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

}
