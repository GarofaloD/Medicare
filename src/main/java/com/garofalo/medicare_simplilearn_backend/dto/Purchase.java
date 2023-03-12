package com.garofalo.medicare_simplilearn_backend.dto;

import com.garofalo.medicare_simplilearn_backend.entity.Address;
import com.garofalo.medicare_simplilearn_backend.entity.Customer;
import com.garofalo.medicare_simplilearn_backend.entity.SystemOrder;
import com.garofalo.medicare_simplilearn_backend.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address address;
    private SystemOrder systemOrder;
    private Set<OrderItem> orderItems;


}
