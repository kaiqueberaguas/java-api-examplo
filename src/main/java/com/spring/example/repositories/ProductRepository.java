package com.spring.example.repositories;

import com.spring.example.entitys.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

}
