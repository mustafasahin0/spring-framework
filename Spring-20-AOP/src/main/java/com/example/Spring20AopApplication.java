package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.ModelMap;

@SpringBootApplication
public class Spring20AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring20AopApplication.class, args);
    }

    public ModelMapper mapper() {
        return new ModelMapper();
    }

}
