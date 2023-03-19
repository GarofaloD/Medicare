package com.garofalo.medicare_simplilearn_backend.configuration;

import com.garofalo.medicare_simplilearn_backend.entity.Product;
import com.garofalo.medicare_simplilearn_backend.entity.ProductCategory;
import com.garofalo.medicare_simplilearn_backend.entity.ProductManufacturer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import jakarta.persistence.metamodel.Type;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class DataRestConfiguration implements RepositoryRestConfigurer {


    //Properties
    private EntityManager entityManager;

    //Constructor


    public DataRestConfiguration(EntityManager theEntityManager) {
      entityManager = theEntityManager;
    }

    //Custom Methods
    @Override //Necessary method
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
       RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        //unsopported actions (temporarily)
        //HttpMethod[] unsopportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

        //disable the methods for product
        config.getExposureConfiguration()
                .forDomainType(Product.class); //applies for Product repository
                //and we make sure we disable for the list of methods.
//                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsopportedActions))
//                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsopportedActions));
//

        //disable the methods for product category
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class); //applies for Product repository
                //and we make sure we disable for the list of methods.
//                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsopportedActions))
//                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsopportedActions));

        config.getExposureConfiguration()
                .forDomainType(ProductManufacturer.class);



        //Call internal helper method to expose id of categories
        exposeIds(config);

    }





    private void exposeIds(RepositoryRestConfiguration config) {
        //expose entity id

        //get list of entity classes
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //array of entities
        List<Class> entityClasses = new ArrayList<>();

        //entity types
        for (EntityType tempEntityType: entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        //expose the entity ids
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);




    }


}
