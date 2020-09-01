package com.spring.example.repositories;

import com.spring.example.entitys.SubcategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity,Long> {

}
