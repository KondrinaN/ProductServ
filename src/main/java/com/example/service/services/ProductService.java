package com.example.service.services;

import com.example.service.models.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
}
