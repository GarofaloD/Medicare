package com.garofalo.medicare_simplilearn_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class Product {

    //PROPERTIES
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity marker
    private int id;
    private String sku;
    private String name;
    private String description;
    private String manufacturer;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date lastUpdated;

    //rep of the relationship in the db: Many products can belong to one category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    //rep of the relationship in the db. Many products can be made by a singe manufacturer
    @ManyToOne
    @JoinColumn(name = "product_manufacturer_id")
    private ProductManufacturer productManufacturer;


}
