package com.example.shopspring.services;

import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    public Market getMarketByProduct(Long dogId) {
        return session.createQuery("from Product where id = :id", Product.class)
                .setParameter("id",dogId).getSingleResult().getMarket();
    }
}
