package com.spring.example.controllers.parameters;

import com.spring.example.models.Category;
import com.spring.example.models.Subcategory;

public class SubcategoryParameter {

    private String subcategoryCode;
    private String name;
    private String description;
    private String categoryCode;

    public String getSubcategoryCode() {
        return subcategoryCode;
    }

    public void setSubcategoryCode(String subcategoryCode) {
        this.subcategoryCode = subcategoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Subcategory toModel(){
        var model = new Subcategory();
        model.setSubcategoryCode(this.subcategoryCode);
        model.setName(this.name);
        model.setDescription(this.description);
        var category = new Category();
        category.setCategoryCode(this.categoryCode);
        model.setCategory(category);
        return model;
    }
}
