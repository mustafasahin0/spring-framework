package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

}
