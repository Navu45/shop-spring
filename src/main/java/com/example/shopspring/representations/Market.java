package com.example.shopspring.representations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "markets")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Market implements Nameable {

    @Id
    @Column(name = "id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "markets_id_seq")
    @SequenceGenerator(name = "markets_id_seq", sequenceName = "markets_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "market")
    private List<Product> marketProducts;

    public Market() {
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
