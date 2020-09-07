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
import javax.persistence.Table;
import com.spring.example.models.Subcategory;

@Entity
@Table(name = "SUBCATEGORY")
public class SubcategoryEntity {
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name = "SUBCATEGORY_CODE",unique = true)
    private String subcategoryCode;

    @Column(name = "NAME",length = 25)
    private String name;
    
    @Column(name = "DESCRIPTION",length = 100)
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
        if(subcategory != null){
            this.id = subcategory.getId();
            this.subcategoryCode = subcategory.getSubcategoryCode();
            this.name = subcategory.getName();
            this.description = subcategory.getDescription();
            this.category = new CategoryEntity(subcategory.getCategory());
            if(subcategory.getLastUpdate() != null)
                this.lastUpdate = Timestamp.valueOf(subcategory.getLastUpdate());
            if(subcategory.getRegisterDate() != null)
                this.registerDate = Timestamp.valueOf(subcategory.getRegisterDate());
            if(subcategory.getProducts() != null)
                this.products = subcategory.getProducts().stream()
                .map(p -> new ProductEntity(p)).collect(Collectors.toList());
        }
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
        if(this.category != null)
            model.setCategory(this.category.toModel());
        if(this.products != null && !this.products.isEmpty())
            model.setProducts(this.products.stream().map(p -> p.toModel())
                .collect(Collectors.toList()));
        if(this.lastUpdate != null)
            model.setLastUpdate(this.lastUpdate.toLocalDateTime());
        if(this.registerDate != null)
            model.setRegisterDate(this.registerDate.toLocalDateTime());
        return model;
    }

}
