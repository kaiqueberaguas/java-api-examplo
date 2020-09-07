package com.spring.example.services.impl;

import java.util.UUID;
import java.util.stream.Collectors;

import com.spring.example.entitys.SubcategoryEntity;
import com.spring.example.models.Subcategory;
import com.spring.example.repositories.SubcategoryRepository;
import com.spring.example.services.SubcategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubcategoryServiceImpl implements SubcategoryService{

	@Autowired
    private SubcategoryRepository subcategoryRepository;

	@Override
	public Page<Subcategory> findAll(int page, int size) {
        Page<Subcategory> response = null;
        var pageable = PageRequest.of(page, size);
        var responseEntity = this.subcategoryRepository.findAll(pageable);
        response = new PageImpl<>(responseEntity.stream().map(r -> r.toModel()).collect(Collectors.toList())
        , responseEntity.getPageable(),responseEntity.getTotalElements());
        return response;
	}

	@Override
	public Subcategory find(String subcategoryCode) {
		Subcategory response = null;
		response = this.subcategoryRepository.findBySubcategoryCode(subcategoryCode).toModel();
		return response;
	}

	@Transactional
	@Override
	public Subcategory create(Subcategory subcategory) {
		Subcategory response = null;
		subcategory.setSubcategoryCode(String.valueOf(subcategory.hashCode()).replaceAll("-", ""));
		response = this.subcategoryRepository.save(new SubcategoryEntity(subcategory)).toModel();
		return response;
	}

	@Transactional
	@Override
	public Subcategory update(Subcategory subcategory) {
		Subcategory response = null;
        if(this.subcategoryRepository.findBySubcategoryCode(subcategory.getSubcategoryCode()) != null)
            response = this.subcategoryRepository.save(new SubcategoryEntity(subcategory)).toModel();
		return response;
	}

	@Transactional
	@Override
	public Subcategory delete(String subcategoryCode) {
		Subcategory response = null;
		response = this.subcategoryRepository.deleteBySubcategoryCode(subcategoryCode).toModel();
		return response;
	}
    
}