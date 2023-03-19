package com.garofalo.medicare_simplilearn_backend.repository;

import com.garofalo.medicare_simplilearn_backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //looking into the customer table by email - returns null if not found
    Customer findByEmail(String customerEmail);



}
