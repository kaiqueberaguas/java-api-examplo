package com.spring.example.presenters;

import java.util.List;

import com.spring.example.models.Category;

public class CategoryPresenter {
    private String categoryCode;
	private String nome;
    private String descricao;
    private List<SubcategoryPresenter> subcategories;

    public CategoryPresenter(Category category) {
        this.categoryCode = categoryCode;
        this.nome = nome;
        this.descricao = descricao;
        this.subcategories = subcategories;
    }

    
}