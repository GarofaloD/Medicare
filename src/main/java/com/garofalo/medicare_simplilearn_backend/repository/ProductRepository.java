package com.garofalo.medicare_simplilearn_backend.repository;

import com.garofalo.medicare_simplilearn_backend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //find items by category. path will be 'api/products/search/findByCategoryId?id=XX'
    //Similar to @Query. Will provide a list of all the elements based on the id
    //Data Rest will automatically expose the endpoint
    Page<Product> findByCategoryId(@Param("id") int id, Pageable pageable);


}
