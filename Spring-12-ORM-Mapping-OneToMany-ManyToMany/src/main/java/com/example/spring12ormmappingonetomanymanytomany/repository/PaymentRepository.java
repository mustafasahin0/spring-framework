package com.example.spring12ormmappingonetomanymanytomany.repository;

import com.example.spring12ormmappingonetomanymanytomany.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
