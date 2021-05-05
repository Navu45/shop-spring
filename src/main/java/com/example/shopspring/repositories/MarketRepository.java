package com.example.shopspring.repositories;

import com.example.shopspring.representations.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    List<Market> findMarketsByNameContaining(String str);
    List<Market> findMarketsByAddressContaining(String str);
    Market deleteByAddressAndName(String address, String name);
}