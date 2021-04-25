package com.example.shopspring.controllers;

import com.example.shopspring.repositories.MarketRepository;
import com.example.shopspring.representations.Market;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

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
    ResponseEntity<?> deleteMarket(@RequestBody Market market) {
        marketRepository.deleteById(market.getId());
        if (!marketRepository.findAll().contains(market))
            return ResponseEntity.ok("DELETED");
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/markets")
    Market createMarket(@RequestBody Market market) {
        return marketRepository.save(market);
    }
}