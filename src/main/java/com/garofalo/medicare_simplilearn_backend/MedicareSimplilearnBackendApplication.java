package com.garofalo.medicare_simplilearn_backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MedicareSimplilearnBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicareSimplilearnBackendApplication.class, args);
    }

}
