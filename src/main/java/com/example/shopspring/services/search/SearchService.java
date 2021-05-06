package com.example.shopspring.services.search;

import com.example.shopspring.representations.Nameable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

public interface SearchService<V extends Nameable> {
    List<V> findBySearchStr(String str, String key);
    void delete(V model);
    V create(V model);
}
