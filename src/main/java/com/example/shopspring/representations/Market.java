package com.example.shopspring.representations;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Market implements Nameable {

    private String name;
    private String address;

    public Market(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Market() {
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market market = (Market) o;
        return name.equals(market.getName()) &&
                address.equals(market.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }


}
