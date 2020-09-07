package com.spring.example.repositories;

import com.spring.example.entitys.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    ProductEntity findByProductCode(String productCode);
    ProductEntity deleteByProductCode(String productCode);
}
