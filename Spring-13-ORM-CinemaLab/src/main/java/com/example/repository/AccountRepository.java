package com.example.repository;

import com.example.entity.Account;
import com.example.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountry(String country);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(int startRange, int endRange);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressContains(String pattern);

    //Write a derived query to sort the list of accounts with age
    List<Account> findByAgeOrderBy(int age);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM Account a")
    List<Account> getAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a WHERE a.role = 'ADMIN'")
    List<Account> getAllAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a WHERE a.age = ?1")
    List<Account> getAccountByAge(int age);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM Accounts WHERE age < ?1", nativeQuery = true)
    List<Account> getAllAccountsWithAgeLessThan(int age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM Accounts WHERE name = ?1 OR address = ?1 OR country = ?1 OR state = ?1 OR state = ?1", nativeQuery = true)
    List<Account> getAllAccountsByPattern(String pattern);
    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM Accounts WHERE age < ?1", nativeQuery = true)
    List<Account> getAccountByAgeLowerThan(int age);
}
