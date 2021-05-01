package com.example.shopspring.controllers;

import com.example.shopspring.repositories.ProductRepository;
import com.example.shopspring.repositories.ProductRepository;
import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import com.example.shopspring.representations.Product;
import com.example.shopspring.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductRepository productRepository;
    private ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
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

    @GetMapping(value = "/products/{productId}/market")
    public @ResponseBody
    Market getMarketUser(@PathVariable("productId")
                                                 Long productId){
        return productService.getMarketByProduct(productId);
    }
}
