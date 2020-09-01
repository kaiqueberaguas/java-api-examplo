package com.spring.example.entitys;

import com.spring.example.entitys.ProductEntity;
import com.spring.example.models.Product;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductEntity{
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "PRICE")
    private double price;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "SUBCATEGORY")
    private SubcategoryEntity subcategory;

    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

    @Column(name = "REGISTER_DATE")
    private Timestamp registerDate;
    
    public ProductEntity() {
    }

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.productCode = product.getProductCode();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.subcategory = new SubcategoryEntity(product.getSubcategory());
        this.lastUpdate = Timestamp.valueOf(product.getLastUpdate());
        this.registerDate = Timestamp.valueOf(product.getRegisterDate());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubcategoryEntity getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubcategoryEntity subcategory) {
        this.subcategory = subcategory;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }   

    public Product toModel(){
        var model =  new Product();
        model.setId(this.id);
        model.setName(this.name);
        model.setProductCode(this.productCode);
        model.setDescription(this.description);
        model.setPrice(this.price);
        model.setSubcategory(subcategory.toModel());
        model.setLastUpdate(this.lastUpdate.toLocalDateTime());
        model.setRegisterDate(this.registerDate.toLocalDateTime());
        return model;
    }

}
