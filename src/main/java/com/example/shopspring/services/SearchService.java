package com.example.shopspring.services;

import com.example.shopspring.representations.Nameable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan
public interface SearchService<V extends Nameable> {
    List<V> getModelBySearchStr(String str, String key);
}
