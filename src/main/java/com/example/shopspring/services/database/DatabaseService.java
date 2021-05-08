package com.example.shopspring.services.database;

import com.example.shopspring.representations.Nameable;

import java.util.List;

public interface DatabaseService<V extends Nameable> {
    List<V> findBySearchStr(String str, String key);
    void delete(V model);
    V create(V model);
}
