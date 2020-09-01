package com.spring.example.services;

import java.util.List;

import com.spring.example.models.Product;

public interface ProductService {
    List<Product> findAll(int page, int size);
    Product findById(Product product);
    Product create(Product product);
    Product update(Product product);
    Product partialUpdate(Product product);
    Product delete(Product product);
}
