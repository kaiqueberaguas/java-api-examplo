package com.spring.example.controllers.parameters;

import java.math.BigDecimal;

import com.spring.example.models.Product;
import com.spring.example.models.Subcategory;

public class ProductParameter {
    
    private String productCode;
	private String name;
    private BigDecimal price;
    private String description;
    private String information;
    private String subcategoryCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getSubcategoryCode() {
        return subcategoryCode;
    }

    public void setSubcategoryCode(String subcategoryCode) {
        this.subcategoryCode = subcategoryCode;
    }

    public Product toModel(){
        var model = new Product();
        model.setProductCode(this.productCode);
        model.setName(this.name);
        model.setDescription(this.description);
        model.setPrice(this.price);
        model.setInformation(this.information);
        var subcategory = new Subcategory();
        subcategory.setSubcategoryCode(this.subcategoryCode);
        model.setSubcategory(subcategory);
        return model;
    }
}