package com.example.service.dao;

import com.example.service.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        try
        {
            TypedQuery<Product> query = entityManager.createNamedQuery("Products.findAll", Product.class);
            List<Product> products = query.getResultList();
            return products;
        }
        catch (NoResultException exc)
        {
            return null;
        }
    }
}
