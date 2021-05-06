package com.example.shopspring.controllers;

import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import com.example.shopspring.services.search.ProductService;
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
    public @ResponseBody
    List<Product> getProducts() {
        return productService.findAllProducts();
    }

    @DeleteMapping("/products")
    public @ResponseBody
    void deleteProduct(@RequestBody Product product) {
        productService.delete(product);
    }

    @PostMapping("/products")
    public @ResponseBody
    Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping(value = "/products/search/market")
    public @ResponseBody
    Market getMarketByProduct(@RequestBody Product product){
        return productService.getMarketByProduct(product);
    }

    @GetMapping("/products/search/product/price")
    @ResponseBody List<Product> getProductByCost(@RequestBody Map<String, String> params) {
        return productService.findBySearchStr(params.get("between"), "price");
    }

    @GetMapping("/products/search/product/name")
    @ResponseBody List<Product> getProductByName(@RequestBody Map<String, String> params) {
        return productService.findBySearchStr(params.get("search"), "name");
    }
}
