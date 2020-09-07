package com.spring.example.services;

import com.spring.example.models.Subcategory;

import org.springframework.data.domain.Page;


public interface SubcategoryService {
    
    Page<Subcategory> findAll(int page, int size);
    Subcategory find(String subcategoryCode);
    Subcategory create(Subcategory subcategory);
    Subcategory update(Subcategory subcategory);
    Subcategory delete(String subcategoryCode);
}
