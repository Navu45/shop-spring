package com.example.shopspring.repositories;

import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByNameContaining(String str);
    List<Product> findProductsByPriceBetween(double moreThan, double lessThan);
    Product findProductByNameAndPrice(String name, double price);
    Product deleteByPriceAndName(double price, String name);
}