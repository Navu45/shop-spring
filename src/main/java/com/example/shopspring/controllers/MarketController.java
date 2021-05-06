package com.example.shopspring.controllers;

import com.example.shopspring.representations.Market;
import com.example.shopspring.services.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MarketController {

    private MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/markets")
    List<Market> getMarkets() {
        return marketService.findAll();
    }


    @DeleteMapping("/markets")
    @ResponseBody void
    deleteMarket(@RequestBody Market market) {
        marketService.delete(market);
    }

    @PostMapping("/markets")
    Market createMarket(@RequestBody Market market) {
        return marketService.create(market);
    }

    @GetMapping("/markets/search/name")
    @ResponseBody List<Market> getMarketByName(@RequestBody Map<String, String> params) {
        return marketService.findBySearchStr(params.get("search"), "name");
    }

    @GetMapping("/markets/search/address")
    @ResponseBody List<Market> getMarketByAddress(@RequestBody Map<String, String> params) {
        return marketService.findBySearchStr(params.get("search"), "address");
    }
}