package com.garofalo.medicare_simplilearn_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;

}
