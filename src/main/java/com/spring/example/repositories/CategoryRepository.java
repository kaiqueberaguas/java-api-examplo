package com.spring.example.repositories;

import com.spring.example.entitys.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    CategoryEntity findByCategoryCode(String categoryCode);
    CategoryEntity deleteByCategoryCode(String categoryCode);
}
