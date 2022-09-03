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
    List<Account> findByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(Integer age1, Integer age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String keyword);

    //Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAgeDesc();
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM Account a")
    List<Account> fetchAllJPQL();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a WHERE a.role = 'ADMIN'")
    List<Account> fetchAdminUsers();

    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a ORDER BY a.age DESC")
    List<Account> orderWithAgeJPQL();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age < ?1", nativeQuery = true)
    List<Account> retrieveAllByAgeLowerThan(@Param("age") Integer age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details WHERE name ILIKE concat('%', ?1, '%') OR address ILIKE concat('%', ?1, '%') OR country ILIKE concat('%', ?1, '%') OR state ILIKE concat('%', ?1, '%') OR state ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Account> retrieveBySearchCriteria(@Param("pattern") String pattern);

    //Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "SELECT * FROM account_details WHERE age > ?1", nativeQuery = true)
    List<Account> getAccountByAgeHigherThanAge(@Param("age") Integer age);
}
