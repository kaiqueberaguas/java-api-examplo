package com.spring.example.services.impl;

import java.util.stream.Collectors;

import com.spring.example.entitys.CategoryEntity;
import com.spring.example.models.Category;
import com.spring.example.repositories.CategoryRepository;
import com.spring.example.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(int page, int size) {
        Page<Category> response = null;
        var pageable = PageRequest.of(page, size);
        var responseEntity= this.categoryRepository.findAll(pageable);
        response = new PageImpl<>(responseEntity.getContent().stream().map(r -> r.toModel()).collect(Collectors.toList()),
            responseEntity.getPageable(),responseEntity.getTotalElements());
        return response;
    }

    @Override
    public Category find(String categoryCode) {
        Category response = null;
        response = this.categoryRepository.findByCategoryCode(categoryCode).toModel();
        return response;
    }

    @Transactional
    @Override
    public Category create(Category category) {
        Category response = null;
            category.setCategoryCode(String.valueOf(category.hashCode()).replaceAll("-",""));

        response = this.categoryRepository.save(new CategoryEntity(category)).toModel();
        return response;
    }

    @Transactional
    @Override
    public Category update(Category category) {
        Category response = null;
        if(this.categoryRepository.findByCategoryCode(category.getCategoryCode()) != null)
            response = this.categoryRepository.save(new CategoryEntity(category)).toModel();
        return response;
    }

    @Transactional
    @Override
    public Category delete(String categoryCode) {
        Category response = null;
        response = this.categoryRepository.deleteByCategoryCode(categoryCode).toModel();
        return response;
    }

}