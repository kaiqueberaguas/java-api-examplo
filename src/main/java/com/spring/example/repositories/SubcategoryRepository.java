package com.spring.example.repositories;

import com.spring.example.entitys.SubcategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity,Long> {
    SubcategoryEntity findBySubcategoryCode(String subcategoryCode);
    SubcategoryEntity deleteBySubcategoryCode(String subcategoryCode);
}
