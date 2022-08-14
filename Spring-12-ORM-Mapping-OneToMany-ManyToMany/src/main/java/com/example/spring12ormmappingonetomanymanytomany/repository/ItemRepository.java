package com.example.spring12ormmappingonetomanymanytomany.repository;

import com.example.spring12ormmappingonetomanymanytomany.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
