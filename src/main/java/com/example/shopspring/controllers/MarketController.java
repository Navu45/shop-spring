package com.example.shopspring.controllers;

import com.example.shopspring.repositories.MarketRepository;
import com.example.shopspring.representations.Market;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return marketRepository.getAll();
    }

    @DeleteMapping("/markets")
    Market deleteMarket(@RequestBody Market market) {
        return marketRepository.delete(market);
    }

    @PostMapping("/markets")
    ResponseEntity<HttpStatus> createMarket(@RequestBody Market market) {
        boolean created = marketRepository.create(market);
        System.out.print(market.toString());
        if (created)
            return ResponseEntity.ok(HttpStatus.CREATED);
        return ResponseEntity.badRequest().build();
    }
}