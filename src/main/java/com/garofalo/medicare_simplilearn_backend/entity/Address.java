package com.garofalo.medicare_simplilearn_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn //Defaults to the same name as the primary key column of the primary table (systemOrder)
    private SystemOrder systemOrder;

}
