package com.example.shopspring.services.database;

import com.example.shopspring.repositories.MarketRepository;
import com.example.shopspring.representations.Market;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class MarketService implements DatabaseService<Market> {
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
    void delete(Market market) {
        log.info("delete market " + market.toString());
        repository.deleteByAddressAndName(market.getAddress(), market.getName());
    }

    @Bean
    public @ResponseBody
    List<Market> findAllMarkets() {
        log.info("get all markets");
        return repository.findAll();
    }

    public @ResponseBody
    Market create(Market market) {
        log.info("save market " + market.toString());
        return repository.save(market);
    }
}