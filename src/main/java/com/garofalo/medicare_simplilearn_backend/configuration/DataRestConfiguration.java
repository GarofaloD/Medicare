package com.garofalo.medicare_simplilearn_backend.configuration;

import com.garofalo.medicare_simplilearn_backend.entity.Product;
import com.garofalo.medicare_simplilearn_backend.entity.ProductCategory;
import com.garofalo.medicare_simplilearn_backend.entity.ProductManufacturer;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class DataRestConfiguration implements RepositoryRestConfigurer {

    @Override //Necessary method
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        //RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        //unsopported actions (temporarily)
        //HttpMethod[] unsopportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //disable the methods for product
        config.getExposureConfiguration()
                .forDomainType(Product.class); //applies for Product repository
                //and we make sure we disable for the list of methods.
//                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsopportedActions))
//                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsopportedActions));

        //disable the methods for product category
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class); //applies for Product repository
                //and we make sure we disable for the list of methods.
//                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsopportedActions))
//                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsopportedActions));

        config.getExposureConfiguration()
                .forDomainType(ProductManufacturer.class);


    }
}
