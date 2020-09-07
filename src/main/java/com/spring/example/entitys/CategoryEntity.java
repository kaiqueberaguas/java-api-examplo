package com.spring.example.entitys;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.spring.example.models.Category;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @Column(name = "CATEGORY_CODE",unique = true)
    private String categoryCode;

    @Column(name = "NAME",length = 25)
    private String name;
    
    @Column(name = "DESCRIPTION",length = 100)
    private String description;

    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

    @Column(name = "REGISTER_DATE")
    private Timestamp registerDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "SUBCATEGORY")
    private List<SubcategoryEntity> subcategories;

    public CategoryEntity() {
    }

    public CategoryEntity(Category category) {
        if(category != null){
            this.id = category.getId();
            this.categoryCode = category.getCategoryCode();
            this.name = category.getName();
            this.description = category.getDescription();
            if(category.getLastUpdate() != null)
                this.lastUpdate = Timestamp.valueOf(category.getLastUpdate());
            if(category.getRegisterDate() != null)
                this.registerDate = Timestamp.valueOf(category.getRegisterDate());
            if(category.getSubcategories() != null)
                this.subcategories = category.getSubcategories().stream()
            .map(s -> new SubcategoryEntity(s)).collect(Collectors.toList());
        }
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
        if(this.lastUpdate != null)
            model.setLastUpdate(this.lastUpdate.toLocalDateTime());
        if(this.registerDate != null)
            model.setRegisterDate(this.registerDate.toLocalDateTime());
        if(this.subcategories != null && !this.subcategories.isEmpty()){
            model.setSubcategories(this.subcategories.stream().map(s -> s.toModel()).collect(Collectors.toList()));

        }
        return model;
    }

}