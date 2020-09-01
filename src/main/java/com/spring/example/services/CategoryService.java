package com.spring.example.services;

import java.util.List;

import com.spring.example.models.Category;

public interface CategoryService {
    List<Category> findAll(int page, int size);
    Category findById(Category category);
    Category create(Category category);
    Category update(Category category);
    Category partialUpdate(Category category);
    Category delete(Category category);
}
