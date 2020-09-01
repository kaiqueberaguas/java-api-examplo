package com.spring.example.services;

import java.util.List;

import com.spring.example.models.Subcategory;


public interface SubcategoryService {
    
    List<Subcategory> findAll(int page, int size);
    Subcategory findById(String subcategoryCode);
    Subcategory create(Subcategory subcategory);
    Subcategory update(Subcategory subcategory);
    Subcategory partialUpdate(Subcategory subcategory);
    Subcategory delete(Subcategory subcategory);
}
