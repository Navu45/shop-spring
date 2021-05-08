package com.example.shopspring.controllers;

import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import com.example.shopspring.services.database.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAllProducts();
    }

    @DeleteMapping("/products")
    public void deleteProduct(@RequestBody Product product) {
        productService.delete(product);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping(value = "/products/search/market")
    public Market getMarketByProduct(@RequestBody Product product) {
        return productService.getMarketByProduct(product);
    }

    @GetMapping("/products/search/product/price")
    List<Product> getProductByCost(@RequestBody Map<String, String> params) {
        return productService.findBySearchStr(params.get("between"), "price");
    }

    @GetMapping("/products/search/product/name")
    List<Product> getProductByName(@RequestBody Map<String, String> params) {
        return productService.findBySearchStr(params.get("search"), "name");
    }
}
