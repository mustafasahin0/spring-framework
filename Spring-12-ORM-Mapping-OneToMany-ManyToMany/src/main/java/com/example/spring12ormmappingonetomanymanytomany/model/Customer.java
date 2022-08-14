package com.example.spring12ormmappingonetomanymanytomany.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Data
public class Customer extends BaseEntity{

    private String address;
    private String email;
    @Column(name = "name")
    private String firstname;
    @Column(name = "sur_name")
    private String lastName;
    private String userName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Payment> payment;

    public Customer(String address, String email, String firstname, String lastName, String userName) {
        this.address = address;
        this.email = email;
        this.firstname = firstname;
        this.lastName = lastName;
        this.userName = userName;
    }
}
