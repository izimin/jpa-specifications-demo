package ru.izimin.jpaspecificationsdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class JpaSpecificationsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSpecificationsDemoApplication.class, args);
    }

}
