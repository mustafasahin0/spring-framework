package com.example.spring12ormmappingonetomanymanytomany.repository;

import com.example.spring12ormmappingonetomanymanytomany.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
