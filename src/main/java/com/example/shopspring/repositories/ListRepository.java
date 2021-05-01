package com.example.shopspring.repositories;

import com.example.shopspring.representations.Nameable;

import java.util.ArrayList;
import java.util.List;

public class ListRepository<T extends Nameable> implements CDFARepository<String, T>{
    ArrayList<T> objs;

    public ListRepository(ArrayList<T> objs) {
        this.objs = objs;
    }

    @Override
    public List<T> getAll() {
        return objs;
    }

    @Override
    public T delete(T obj) {
        T result = null;
        for (int i = 0; i < objs.size(); i++) {
            if (objs.get(i).equals(obj))
            {
                result = objs.remove(i);
                break;
            }
        }
        return result;
    }

    @Override
    public boolean create(T obj) {
        if (objs.contains(obj))
            return false;
        objs.add(obj);
        return true;
    }
}