package com.garofalo.medicare_simplilearn_backend.service;

import com.garofalo.medicare_simplilearn_backend.dto.Purchase;
import com.garofalo.medicare_simplilearn_backend.dto.PurchaseResponse;
import com.garofalo.medicare_simplilearn_backend.entity.Customer;
import com.garofalo.medicare_simplilearn_backend.entity.Order;
import com.garofalo.medicare_simplilearn_backend.entity.OrderItem;
import com.garofalo.medicare_simplilearn_backend.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // get order
        Order order = purchase.getOrder();

        // create tracker
        String orderTracker = getOrderTracker();
        order.setOrderTracker(orderTracker);

        // Grab the items that are passed in the purchase object...
        Set<OrderItem> orderItems = purchase.getOrderItems();
        //...and add each of the items to the order
        orderItems.forEach(item -> order.add(item));

        // get the address in the purchase object and add it to the order
        order.setAddress(purchase.getShippingAddress());

        //Create a new customer object based on what's coming from the purchase...
        Customer customer = purchase.getCustomer();
        //...and add this created order to that customer
        customer.add(order);

        // then save the customer
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTracker);
    }



    //AUX METHODS
    private static String getOrderTracker() {

        UUID uuidTracker = UUID.randomUUID();
        return uuidTracker.toString();
    }


}
