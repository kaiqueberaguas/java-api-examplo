package com.spring.example.repositories;

import com.spring.example.entitys.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

}
