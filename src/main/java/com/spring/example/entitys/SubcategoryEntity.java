package com.spring.example.entitys;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.spring.example.models.Subcategory;

@Entity
public class SubcategoryEntity {
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name = "SUBCATEGORY_CODE")
    private String subcategoryCode;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CATEGORY")
    private CategoryEntity category;

    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;
    
    @Column(name = "REGISTER_DATE")
    private Timestamp registerDate;
    
    @OneToMany
    @JoinColumn(name = "PRODUCT")
    private List<ProductEntity> products;

    public SubcategoryEntity() {
    }

    public SubcategoryEntity(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.subcategoryCode = subcategory.getSubcategoryCode();
        this.name = subcategory.getName();
        this.description = subcategory.getDescription();
        this.category = new CategoryEntity(subcategory.getCategory());
        this.lastUpdate = Timestamp.valueOf(subcategory.getLastUpdate());
        this.registerDate = Timestamp.valueOf(subcategory.getRegisterDate());
        this.products = subcategory.getProducts().stream()
            .map(p -> new ProductEntity(p)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
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
  
    public Subcategory toModel(){
        var model = new Subcategory();
        model.setId(this.id);
        model.setSubcategoryCode(this.subcategoryCode);
        model.setName(this.name);
        model.setDescription(this.description);
        model.setCategory(this.category.toModel());
        model.setProducts(this.products.stream().map(p -> p.toModel())
            .collect(Collectors.toList()));
        model.setLastUpdate(this.lastUpdate.toLocalDateTime());
        model.setRegisterDate(this.registerDate.toLocalDateTime());
        return model;
    }

}
