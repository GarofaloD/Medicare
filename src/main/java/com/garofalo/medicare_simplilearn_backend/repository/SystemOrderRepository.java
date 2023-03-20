package com.garofalo.medicare_simplilearn_backend.repository;

import com.garofalo.medicare_simplilearn_backend.entity.SystemOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface SystemOrderRepository extends JpaRepository<SystemOrder, Integer> {

    //find customer by email
    Page<SystemOrder> findByCustomerEmail(@Param("email") String email, Pageable pageable);

}
