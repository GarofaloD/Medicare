package com.garofalo.medicare_simplilearn_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) //one customer can have many orders
    private Set<Order> orders = new HashSet<>();



    //AUX METHODS
    public void add(Order order){
        //If the item being passed is not null...
        if (order != null){

            //and the array or items is not null
            if(orders == null){
                //create a new set for the items
                orders = new HashSet<>();
            }

            //then, add the item
            orders.add(order);
            order.setCustomer(this);


        }

    }

}
