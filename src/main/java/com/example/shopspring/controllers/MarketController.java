package com.example.shopspring.controllers;

import com.example.shopspring.repositories.MarketRepository;
import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import com.example.shopspring.services.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MarketController {

    private MarketRepository marketRepository;
    private MarketService marketService;

    public MarketController(MarketRepository marketRepository, MarketService marketService) {
        this.marketRepository = marketRepository;
        this.marketService = marketService;
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

    @GetMapping("/markets/search/name")
    @ResponseBody List<Market> getMarketByName(@RequestBody Map<String, String> params) {
        return marketService.getModelBySearchStr(params.get("search"), "name");
    }

    @GetMapping("/markets/search/address")
    @ResponseBody List<Market> getMarketByAddress(@RequestBody Map<String, String> params) {
        return marketService.getModelBySearchStr(params.get("search"), "address");
    }
}