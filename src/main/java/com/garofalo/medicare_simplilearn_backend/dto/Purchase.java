package com.garofalo.medicare_simplilearn_backend.dto;

import com.garofalo.medicare_simplilearn_backend.entity.Address;
import com.garofalo.medicare_simplilearn_backend.entity.Customer;
import com.garofalo.medicare_simplilearn_backend.entity.Order;
import com.garofalo.medicare_simplilearn_backend.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Order order;
    private Set<OrderItem> orderItems;


}
