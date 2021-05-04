package com.example.shopspring.services;

import com.example.shopspring.representations.Market;
import com.example.shopspring.representations.Product;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements SearchService<Product>{
    CriteriaBuilder builder;
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
    }
    public Market getMarketByProduct(Product product) {
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> productRoot = criteria.from(Product.class);
        criteria.select(productRoot)
                .where(builder.and(
                        builder.equal(productRoot.get("name"), product.getName()),
                        builder.equal(productRoot.get("price"), product.getPrice())
                ));
        return session.createQuery(criteria).getSingleResult().getMarket();
    }

    @Override
    public List<Product> getModelBySearchStr(String str, String key) {
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> productRoot = criteria.from(Product.class);
        criteria.select(productRoot);
        if (key.equals("name")){
            criteria.where(builder.like(productRoot.get(key), "%" + str + "%"));
        }
        else if (key.equals("price")) {
            String[] betweenPrices = str.split(",");
            criteria.where(builder.between(productRoot.get(key),
                    Double.parseDouble(betweenPrices[0]),
                    Double.parseDouble(betweenPrices[1])));
        }
        return session.createQuery(criteria).getResultList();
    }
}
