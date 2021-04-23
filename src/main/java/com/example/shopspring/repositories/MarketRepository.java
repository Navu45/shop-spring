package com.example.shopspring.repositories;

import com.example.shopspring.representations.Market;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class MarketRepository extends ListRepository<Market>{
    public MarketRepository() {
        super(new ArrayList<>());
        super.getAll().addAll(
                Arrays.asList(
                        new Market("Target", "Gdsagsag street, 13a"),
                        new Market("Auchan", "dfsadfsd street, 8"),
                        new Market("VkusVille", "oiljo street, 107k10"),
                        new Market("Auchan", "yjomhgbgf street, 200")
                )
        );
    }
}
