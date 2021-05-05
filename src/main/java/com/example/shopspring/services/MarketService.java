package com.example.shopspring.services;

import com.example.shopspring.repositories.MarketRepository;
import com.example.shopspring.representations.Market;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Service
@Slf4j
public class MarketService implements SearchService<Market>{
    private MarketRepository repository;

    public MarketService(MarketRepository repository) {
        this.repository = repository;
    }

    @Override
    public @ResponseBody
    List<Market> findBySearchStr(String str, String key) {
        if (key.equals("name")) {
            log.info("find market by name");
            return repository.findMarketsByNameContaining(str);
        }
        else if (key.equals("address")){
            log.info("find market by address '" + str + "'");
            return repository.findMarketsByAddressContaining(str);
        }
        else return null;
    }

    public @ResponseBody
    Market delete(Market market) {
        log.info("delete market " + market.toString());
        return repository.deleteByAddressAndName(market.getAddress(), market.getName());
    }

    public @ResponseBody
    List<Market> findAll() {
        log.info("get all markets");
        return repository.findAll();
    }

    public @ResponseBody
    Market create(Market market) {
        log.info("save market " + market.toString());
        return repository.save(market);
    }
}