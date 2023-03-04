package com.garofalo.medicare_simplilearn_backend.repository;

import com.garofalo.medicare_simplilearn_backend.entity.ProductManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productManufacturer", path="product-manufacturer")
public interface ProductManufacturerRepository extends JpaRepository<ProductManufacturer, Integer> {
}
