package com.example.shopspring.repositories;

import java.util.List;

public interface CDFARepository<K, T> {
    List<T> getAll();
    boolean create(T obj);
    T delete(T obj);
}
