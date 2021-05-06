package com.example.shopspring.services;

import com.example.shopspring.representations.Nameable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public interface SearchService<V extends Nameable> {
    List<V> findBySearchStr(String str, String key);
    void delete(V model);
    List<V> findAll() ;
    V create(V model);
}
