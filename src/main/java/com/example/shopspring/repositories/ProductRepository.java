package com.example.shopspring.repositories;

import com.example.shopspring.representations.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository extends ListRepository<Product> {
    public ProductRepository() {
        super(new ArrayList<>());
        super.getAll().addAll(
                Arrays.asList(
                new Product("butter", 329.00),
                new Product("tomatoes", 250.80),
                new Product("chocolate", 100.99),
                new Product("flour", 66.79)
        ));
    }
}
