package com.spring.example.presenters;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.example.models.Category;
import com.spring.example.models.Subcategory;

public class CategoryPresenter {
    private String categoryCode;
	private String nome;
    private String descricao;
    private List<SubcategoryPresenter> subcategories;

    public CategoryPresenter(Category category) {
        this.categoryCode = category.getCategoryCode();
        this.nome = category.getName();
        this.descricao = category.getDescription();
        if(category.getSubcategories() != null)
            this.subcategories = category.getSubcategories().stream().map(r -> prepare(r)).collect(Collectors.toList());
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<SubcategoryPresenter> getSubcategories() {
        return subcategories;
    }
    
    private SubcategoryPresenter prepare(Subcategory subcategory){
        var model = new Subcategory();
        model.setSubcategoryCode(subcategory.getSubcategoryCode());
        model.setName(subcategory.getName());
        return new SubcategoryPresenter(subcategory);
    }
}