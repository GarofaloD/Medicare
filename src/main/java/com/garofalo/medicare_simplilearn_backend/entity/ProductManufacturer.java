package com.garofalo.medicare_simplilearn_backend.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ProductManufacturer {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity marker
    private int id;
    private String name;
    private String country;

    public ProductManufacturer() {

    }

    public ProductManufacturer(int id, String name, String country, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //CUSTOM METHODS
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer") //manufacturer is in the Product table (foreign key)
    private Set<Product> products;

}
