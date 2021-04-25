package com.example.shopspring.controllers;

import com.example.shopspring.repositories.ProductRepository;
import com.example.shopspring.repositories.ProductRepository;
import com.example.shopspring.representations.Product;
import com.example.shopspring.representations.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    List<Product> getProducts() {
        return productRepository.findAll();
    }

    @DeleteMapping("/products")
    void deleteProduct(@RequestBody Product product) {
        productRepository.deleteById(product.getId());
    }

    @PostMapping("/products")
    Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
