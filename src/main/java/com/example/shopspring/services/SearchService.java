package com.example.shopspring.services;

import com.example.shopspring.representations.Nameable;

import java.util.List;

public interface SearchService<V extends Nameable> {
    List<V> getModelBySearchStr(String str, String key);
}
