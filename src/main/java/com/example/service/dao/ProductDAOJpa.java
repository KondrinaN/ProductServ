package com.example.service.dao;

import com.example.service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAOJpa extends JpaRepository<Product, Long> {
}
