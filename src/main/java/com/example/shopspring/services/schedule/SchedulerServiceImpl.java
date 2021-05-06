package com.example.shopspring.services.schedule;

import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class SchedulerServiceImpl implements SchedulerService {

    List<Market> marketList;
    List<Product> productList;

    public SchedulerServiceImpl(List<Market> marketList, List<Product> productList) {
        this.marketList = marketList;
        this.productList = productList;
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    @Override
    public void doScheduledTask() {
        try {
            File file = new File("tables/markets.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(String.valueOf(marketList));
            writer.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("tables/products.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(String.valueOf(productList));
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
