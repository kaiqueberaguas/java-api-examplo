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
import javax.persistence.OneToMany;

import com.spring.example.models.Category;

@Entity
public class CategoryEntity {
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "CATEGORY_CODE")
    private String categoryCode;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

    @Column(name = "REGISTER_DATE")
    private Timestamp registerDate;

    @OneToMany
    @JoinColumn(name = "SUBCATEGORY")
    private List<SubcategoryEntity> subcategories;

    public CategoryEntity() {
    }

    public CategoryEntity(Category category) {
        this.id = category.getId();
        this.categoryCode = category.getCategoryCode();
        this.name = category.getName();
        this.description = category.getDescription();
        this.lastUpdate = Timestamp.valueOf(category.getLastUpdate());
        this.registerDate = Timestamp.valueOf(category.getRegisterDate());
        this.subcategories = category.getSubcategories().stream()
            .map(s -> new SubcategoryEntity(s)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<SubcategoryEntity> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryEntity> subcategories) {
        this.subcategories = subcategories;
    }

    public Category toModel(){
        var model = new Category();
        model.setId(this.id);
        model.setCategoryCode(this.categoryCode);
        model.setName(this.name);
        model.setDescription(this.description);
        model.setLastUpdate(this.lastUpdate.toLocalDateTime());
        model.setRegisterDate(this.registerDate.toLocalDateTime());
        model.setSubcategories(this.subcategories.stream().map(s -> s.toModel())
            .collect(Collectors.toList()));
        return model;
    }

}