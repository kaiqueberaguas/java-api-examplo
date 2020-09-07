package com.spring.example.presenters;

import com.spring.example.models.Category;
import com.spring.example.models.Subcategory;

public class SubcategoryPresenter {

    private String subcategoryCode;
    private String name;
    private String description;
    private CategoryPresenter category;

    public SubcategoryPresenter(Subcategory subcategory) {
        this.subcategoryCode = subcategory.getSubcategoryCode();
        this.name = subcategory.getName();
        this.description = subcategory.getDescription();
        this.category = this.prepare(subcategory.getCategory());
    }

    public String getSubcategoryCode() {
        return subcategoryCode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CategoryPresenter getCategory() {
        return category;
    }

    private CategoryPresenter prepare(Category category){
        var model = new Category();
        model.setCategoryCode(category.getCategoryCode());
        model.setName(category.getName());
        return new CategoryPresenter(model);
    }
      
}