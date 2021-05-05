package com.example.shopspring.services;

import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Nameable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Configuration
@ComponentScan
public interface SearchService<V extends Nameable> {
    List<V> findBySearchStr(String str, String key);
    V delete(V model);
    List<V> findAll() ;
    V create(V model);
}
