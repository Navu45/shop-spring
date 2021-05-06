package com.example.shopspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShopSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopSpringApplication.class, args);
    }

}
