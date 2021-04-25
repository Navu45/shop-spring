package com.example.shopspring.representations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "markets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Market implements Nameable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "markets_id_seq")
    @SequenceGenerator(name = "markets_id_seq", sequenceName = "markets_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    public Market() {
    }

    public Long getId() {
        return id;
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
