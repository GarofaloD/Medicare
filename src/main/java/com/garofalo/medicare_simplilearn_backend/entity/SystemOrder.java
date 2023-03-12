package com.garofalo.medicare_simplilearn_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class SystemOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderTracker;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date dateUpdated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemOrder")
    private Set<OrderItem> orderItems = new HashSet<>();//an order can have many items

    @ManyToOne
    @JoinColumn
    private Customer customer; //many orders can belong to one customer

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "systemOrder")
    @JoinColumn
    private Address address;


    //AUX METHODS
    public void add(OrderItem item){
        //If the item being passed is not null...
        if (item != null){

            //and the array or items is not null
            if(orderItems == null){
               //create a new set for the items
                orderItems = new HashSet<>();
            }

            //then, add the item
            orderItems.add(item);
            item.setSystemOrder(this);


        }

    }




}
