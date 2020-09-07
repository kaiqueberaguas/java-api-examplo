package com.spring.example.services;

import com.spring.example.models.Category;

import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<Category> findAll(int page, int size);
    Category find(String categoryCode);
    Category create(Category category);
    Category update(Category category);
    Category delete(String categoryCode);
}
