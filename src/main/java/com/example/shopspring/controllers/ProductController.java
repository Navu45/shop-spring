package com.example.shopspring.controllers;

import com.example.shopspring.repositories.ProductRepository;
import com.example.shopspring.repositories.ProductRepository;
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
        return productRepository.getAll();
    }

    @DeleteMapping("/products")
    Product deleteProduct(@RequestBody Product product) {
        return productRepository.delete(product);
    }

    @PostMapping("/products")
    ResponseEntity<HttpStatus> createProduct(@RequestBody Product product) {
        boolean created = productRepository.create(product);
        System.out.print(product.toString());
        if (created)
            return ResponseEntity.ok(HttpStatus.CREATED);
        return ResponseEntity.badRequest().build();
    }
}
