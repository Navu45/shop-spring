package com.example.shopspring.services;

import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Nameable;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketService implements SearchService<Market>{
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder builder;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
    }

    @Override
    public @ResponseBody
    List<Market> getModelBySearchStr(String str, String key) {
        CriteriaQuery<Market> criteria = builder.createQuery( Market.class );
        Root<Market> marketRoot = criteria.from( Market.class );
        criteria.select(marketRoot)
                .where(builder.like(marketRoot.get(key), "%" + str + "%"));
        return session.createQuery(criteria).getResultList();
    }
}