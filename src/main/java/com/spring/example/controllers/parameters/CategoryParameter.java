package com.spring.example.controllers.parameters;

import com.spring.example.models.Category;

public class CategoryParameter {

    private String categoryCode;
    private String name;
    private String description;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
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

    public Category toModel(){
        var model = new Category();
        model.setCategoryCode(this.categoryCode);
        model.setName(this.name);
        model.setDescription(this.description);
        return model;
    }

}
