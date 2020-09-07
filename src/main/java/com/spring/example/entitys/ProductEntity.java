package com.spring.example.entitys;

import com.spring.example.entitys.ProductEntity;
import com.spring.example.models.Product;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity{
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "PRODUCT_CODE",unique = true)
    private String productCode;

    @Length(max = 25)
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "PRICE")
    private BigDecimal price;

    @Length(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
  
    @Length(max = 500)
    @Column(name = "INFORMATION")
    private String information;

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
        if(product != null){
            this.id = product.getId();
            this.productCode = product.getProductCode();
            this.name = product.getName();
            this.price = product.getPrice();
            this.description = product.getDescription();
            this.information = product.getInformation();
            this.subcategory = new SubcategoryEntity(product.getSubcategory());
            if(product.getLastUpdate() != null)
                this.lastUpdate = Timestamp.valueOf(product.getLastUpdate());
            if(product.getRegisterDate() != null)
                this.registerDate = Timestamp.valueOf(product.getRegisterDate());
        }
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
    
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }   

    public Product toModel(){
        var model =  new Product();
        model.setId(this.id);
        model.setName(this.name);
        model.setProductCode(this.productCode);
        model.setDescription(this.description);
        model.setPrice(this.price);
        if(subcategory != null)
            model.setSubcategory(subcategory.toModel());
        if(this.lastUpdate != null)
            model.setLastUpdate(this.lastUpdate.toLocalDateTime());
        if(this.registerDate != null)
            model.setRegisterDate(this.registerDate.toLocalDateTime());
        model.setInformation(this.information);
        return model;
    }
}
