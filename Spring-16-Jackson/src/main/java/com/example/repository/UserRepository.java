package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //    // ------------------- DERIVED QUERIES ------------------- //
//
//    //Write a derived query to read a user with an email?
//    Optional<User> findByEmail(String email);
//
//    //Write a derived query to read a user with an username?
//    Optional<User> findByUsername(String username);
//
//    //Write a derived query to list all users that contain a specific name?
//    List<User> findAllByAccountDetailsNameContaining(String name);
//
//    //Write a derived query to list all users that contain a specific name in the ignore case mode?
//    List<User> findAllByAccountDetailsNameContainingIgnoreCase(String name);
//
//    //Write a derived query to list all users with an age greater than a specified age?
//    List<User> findAllByAccountDetailsAgeGreaterThan(Integer age);
//
//    // ------------------- JPQL QUERIES ------------------- //
//
//    //Write a JPQL query that returns a user read by email?
//    @Query("SELECT u FROM User u WHERE u.email = ?1")
//    Optional<User> fetchByEmailJPQL(String email);
//
//    //Write a JPQL query that returns a user read by username?
//    @Query("SELECT u FROM User u WHERE u.username = ?1")
//    Optional<User> fetchByUsernameJPQL(String username);
//
//    //Write a JPQL query that returns all users?
//    @Query("SELECT u FROM User u")
//    List<User> fetchALlUsers();
//
//    // ------------------- Native QUERIES ------------------- //
//
//    //Write a native query that returns all users that contain a specific name?
//    @Query(value = "SELECT * FROM user_account u " +
//            "JOIN account_details ad ON ad.id = u.account_details_id WHERE ad.name ILIKE concat('%', ?1, '%')", nativeQuery = true)
//    List<User> retrieveAllByName(String name);
//
//    //Write a native query that returns all users?
//    @Query(value = "SELECT * FROM user_account", nativeQuery = true)
//    List<User> retrieveAll();
//
//    //Write a native query that returns all users in the range of ages?
//    @Query(value = "SELECT * FROM user_account u " +
//            "JOIN account_details ad ON ad.id = u.account_details_id WHERE ad.age BETWEEN ?1 AND ?2", nativeQuery = true)
//    List<User> retrieveBetweenAgesRange(Integer first, Integer last);
//
//    //Write a native query to read a user by email?
//    @Query(value = "SELECT * FROM user_account WHERE email = ?1", nativeQuery = true)
//    User retrieveByEmail(String email);

}
