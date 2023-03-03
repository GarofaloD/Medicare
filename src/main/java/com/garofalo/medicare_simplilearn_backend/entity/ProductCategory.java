package com.garofalo.medicare_simplilearn_backend.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ProductCategory {

    //PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoryName;

    //CONSTRUCTORS
    public ProductCategory() {
    }

    public ProductCategory(int id, String categoryName, Set<Product> products) {
        this.id = id;
        this.categoryName = categoryName;
        this.products = products;
    }

    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    //CUSTOM METHODS
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category") //category is in the Product table (foreign key)
    private Set<Product> products;

}
