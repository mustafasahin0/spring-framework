package com.example.spring18restopenapi3;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring18RestOpenApi3Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring18RestOpenApi3Application.class, args);
    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info().title("Cinema Application Open API").version("v1").description("Cinema Application API documentation"));
    }

}
