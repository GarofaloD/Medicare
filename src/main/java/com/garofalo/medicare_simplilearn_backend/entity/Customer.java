package com.garofalo.medicare_simplilearn_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer") //one customer can have many orders
    private Set<SystemOrder> systemOrders = new HashSet<>();



    //AUX METHODS
    public void add(SystemOrder systemOrder){
        //If the item being passed is not null...
        if (systemOrder != null){

            //and the array or items is not null
            if(systemOrders == null){
                //create a new set for the items
                systemOrders = new HashSet<>();
            }

            //then, add the item
            systemOrders.add(systemOrder);
            systemOrder.setCustomer(this);


        }

    }

}
