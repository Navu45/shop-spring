package com.example.shopspring.services;

import com.example.shopspring.repositories.ProductRepository;
import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductService implements SearchService<Product>{

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Market getMarketByProduct(Product product) {
        return repository
                .findProductByNameAndPrice(product.getName(), product.getPrice())
                .getMarket();
    }

    @Override
    public List<Product> getModelBySearchStr(String str, String key) {
        if (key.equals("name")){
            return repository.findProductsByNameContaining(str);
        }
        else if (key.equals("price")) {
            String[] betweenPrices = str.split(",");
            return repository.findProductsByPriceBetween(
                    Double.parseDouble(betweenPrices[0]),
                    Double.parseDouble(betweenPrices[1]));
        }
        return null;
    }
}
