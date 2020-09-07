package com.spring.example.services.impl;

import java.util.stream.Collectors;

import com.spring.example.entitys.ProductEntity;
import com.spring.example.models.Product;
import com.spring.example.repositories.ProductRepository;
import com.spring.example.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(int page, int size) {
        Page<Product> response = null;
        var pageable = PageRequest.of(page, size);
        var responseEntity = this.productRepository.findAll(pageable);
        response = new PageImpl<>(responseEntity.stream().map(r -> r.toModel()).collect(Collectors.toList())
        , responseEntity.getPageable(),responseEntity.getTotalElements());
        return response;
    }

    @Override
    public Product find(String productCode) {
        Product response = null;
        response = this.productRepository.findByProductCode(productCode).toModel();
        return response;
    }
    
    @Transactional
    @Override
    public Product create(Product product) {
        Product response = null;
        product.setProductCode(String.valueOf(product.hashCode()).replaceAll("-", ""));
        response = this.productRepository.save(new ProductEntity(product)).toModel();
        return response;
    }

    @Transactional
    @Override
    public Product update(Product product) {
        Product response = null;
        if(this.productRepository.findByProductCode(product.getProductCode()) != null)
            response = this.productRepository.save(new ProductEntity(product)).toModel();
        return response;
    }

    @Transactional
    @Override
    public Product delete(String productCode) {
        Product response = null;
        response = this.productRepository.deleteByProductCode(productCode).toModel();
        return response;
    }

}