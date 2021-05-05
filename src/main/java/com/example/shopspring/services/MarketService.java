package com.example.shopspring.services;

import com.example.shopspring.repositories.MarketRepository;
import com.example.shopspring.representations.Market;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Service
public class MarketService implements SearchService<Market>{
    private MarketRepository repository;

    public MarketService(MarketRepository repository) {
        this.repository = repository;
    }

    @Override
    public @ResponseBody
    List<Market> getModelBySearchStr(String str, String key) {
        if (key.equals("name"))
            return repository.findMarketsByNameContaining(str);
        else if (key.equals("address"))
            return repository.findMarketsByAddressContaining(str);
        else return null;
    }
}