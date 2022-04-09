package com.cydeo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DealerApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigCar.class);

        Car c = container.getBean(Car.class);
        Person p = container.getBean(Person.class);

        System.out.println("Person's name: " + p.getName());
        System.out.println("Car's make : " + c.getMake());
        System.out.println("Person's car : " + p.getCar().getMake());

    }
}
