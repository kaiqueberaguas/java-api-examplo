package com.spring.example.services;

import com.spring.example.models.Product;

import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> findAll(int page, int size);
    Product find(String productCode);
    Product create(Product product);
    Product update(Product product);
    Product delete(String productCode);
}
