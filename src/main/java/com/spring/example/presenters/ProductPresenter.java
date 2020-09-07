package com.spring.example.presenters;

import java.math.BigDecimal;

import com.spring.example.models.Product;
import com.spring.example.models.Subcategory;

public class ProductPresenter {
    
    private String productCode;
	private String name;
    private BigDecimal price;
    private String description;
    private String information;
    private SubcategoryPresenter subcategory;
    
    public ProductPresenter(Product product){
        this.productCode = product.getProductCode();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.information = product.getInformation();
        this.subcategory = this.prepare(product.getSubcategory());
    }

    public String getInformation(){
        return information;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public SubcategoryPresenter getSubcategory() {
        return subcategory;
    }

    private SubcategoryPresenter prepare(Subcategory subcategory){
        var model = new Subcategory();
        model.setSubcategoryCode(subcategory.getSubcategoryCode());
        model.setName(subcategory.getName());
        return new SubcategoryPresenter(model);
    }
}