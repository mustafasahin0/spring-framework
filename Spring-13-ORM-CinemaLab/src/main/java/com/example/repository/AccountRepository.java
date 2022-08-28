package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state

    //Write a derived query to list all accounts with age lower than or equal to a specific value

    //Write a derived query to list all accounts with a specific role

    //Write a derived query to list all accounts between a range of ages

    //Write a derived query to list all accounts where the beginning of the address contains the keyword

    //Write a derived query to sort the list of accounts with age

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts

    //Write a JPQL query to list all admin accounts

    //Write a JPQL query to sort all accounts with age

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

    //Write a native query to read all accounts with an age lower than a specific value
}
