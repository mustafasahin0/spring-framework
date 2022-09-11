package com.example.repository;

import com.example.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long userId);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id = ?1")
    List<Ticket> fetchAllTicketsByUserAccount(@Param("id") Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> fetchAllTicketsWithRangeOfDates(@Param("dateTime1") LocalDateTime dateTime1, @Param("dateTime2") LocalDateTime dateTime2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT COUNT(*) FROM TICKET WHERE user_account_id = ?1", nativeQuery = true)
    Integer countTicketByUser(@Param("userId") Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1 AND dateTime BETWEEN ?2 AND ?3", nativeQuery = true)
    Integer countTicketByUserInDateRange(@Param("userId") Long userId, @Param("dateTime1") LocalDateTime dateTime1, @Param("dateTime2") LocalDateTime dateTime2);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT DISTINCT(m.name) FROM ticket t JOIN movie_cinema mc ON mc.id = t.movie_cinema_id JOIN movie m ON mc.movie_id = m.id", nativeQuery = true)
    List<String> retrieveAllDistinctMovieNames();

    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id WHERE ua.email = ?1", nativeQuery = true)
    List<Ticket> findAllByUserEmail(@Param("email") String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> retrieveAllTickets();
    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id JOIN account_details ad ON ad.id = ua.account_details_id JOIN movie_cinema mc ON t.movie_cinema_id = mc.id JOIN m ON mc.movie_id = m.id WHERE ua.username ILIKE concat('%', ?1, '%') OR ad.name ILIKE concat('%', ?1, '%') OR m.name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(@Param("searchCriteria") String searchCriteria);
}
