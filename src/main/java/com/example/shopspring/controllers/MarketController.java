package com.example.shopspring.controllers;

import com.example.shopspring.repositories.MarketRepository;
import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import org.hibernate.criterion.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController {

    private MarketRepository marketRepository;

    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @GetMapping("/markets")
    List<Market> getMarkets() {
        return marketRepository.findAll();
    }


    @DeleteMapping("/markets")
    void deleteMarket(@RequestBody Market market) {
        marketRepository.deleteById(market.getId());
    }

    @PostMapping("/markets")
    Market createMarket(@RequestBody Market market) {
        return marketRepository.save(market);
    }
}