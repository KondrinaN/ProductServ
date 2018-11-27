package com.example.service.dao;

import com.example.service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO  {

    Product save(Product product);
    List<Product> findAll();
}
