package com.example.shopspring.services;

import com.example.shopspring.repositories.ProductRepository;
import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ProductService implements SearchService<Product>{

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Market getMarketByProduct(Product product) {
        log.info("find market by product " + product.toString());
        return repository
                .findProductByNameAndPrice(product.getName(), product.getPrice())
                .getMarket();
    }

    @Override
    public List<Product> findBySearchStr(String str, String key) {
        if (key.equals("name")){
            log.info("find product by name, containing '" + str + "'");
            return repository.findProductsByNameContaining(str);
        }
        else if (key.equals("price")) {
            log.info("find market by price between " + str);
            String[] betweenPrices = str.split(",");
            return repository.findProductsByPriceBetween(
                    Double.parseDouble(betweenPrices[0]),
                    Double.parseDouble(betweenPrices[1]));
        }
        return null;
    }

    @Override
    public void delete(Product product) {
        log.info("delete product " + product.toString());
        repository.deleteByPriceAndName(product.getPrice(), product.getName());
    }

    @Override
    public List<Product> findAll() {
        log.info("get all products");
        return repository.findAll();
    }

    @Override
    public Product create(Product product) {
        log.info("save product " + product.toString());
        return repository.save(product);
    }
}
