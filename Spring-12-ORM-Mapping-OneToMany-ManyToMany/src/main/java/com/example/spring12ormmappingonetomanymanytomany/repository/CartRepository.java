package com.example.spring12ormmappingonetomanymanytomany.repository;

import com.example.spring12ormmappingonetomanymanytomany.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
