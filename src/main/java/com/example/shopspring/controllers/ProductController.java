package com.example.shopspring.controllers;

import com.example.shopspring.repositories.ProductRepository;
import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import com.example.shopspring.services.MarketService;
import com.example.shopspring.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    private ProductRepository productRepository;
    private ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/products")
    public @ResponseBody
    List<Product> getProducts() {
        return productRepository.findAll();
    }

    @DeleteMapping("/products")
    public @ResponseBody
    void deleteProduct(@RequestBody Product product) {
        productRepository.deleteById(product.getId());
    }

    @PostMapping("/products")
    public @ResponseBody
    Product createProduct(@RequestBody Product product) {
        Market market = product.getMarket();
        return productRepository.save(product);
    }

    @GetMapping(value = "/products/search/market")
    public @ResponseBody
    Market getMarketByProduct(@RequestBody Product product){
        return productService.getMarketByProduct(product);
    }

    @GetMapping("/products/search/product/price")
    @ResponseBody List<Product> getProductByCost(@RequestBody Map<String, String> params) {
        return productService.getModelBySearchStr(params.get("between"), "price");
    }

    @GetMapping("/products/search/product/name")
    @ResponseBody List<Product> getProductByName(@RequestBody Map<String, String> params) {
        return productService.getModelBySearchStr(params.get("search"), "name");
    }
}
