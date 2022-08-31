package com.example.repository;

import com.example.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Cinema findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country
    // List<Cinema> findCinemasByLocationWher()
    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findCinemaByNameContainsOrSponsoredNameContains(String name, String sponsoredName);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c FROM Cinema c WHERE c.id = ?1")
    Cinema getCinemaName(Long id);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM CINEMAS WHERE location_id = ?1", nativeQuery = true)
    List<Cinema> getAllCinemasByLocation(String location);
    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM CINEMAS WHERE name = ?1 OR sponsored_name ILIKE = '%'+?2+'%'", nativeQuery = true)
    List<Cinema> findCinemasByNameOrSponsaredNameContains(String name, String pattern);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM CINEMAS ORDER BY sponsored_name", nativeQuery = true)
    List<Cinema> sortCinemasByName();
    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT DISTINCT FROM CINEMAS GROUP BY ", nativeQuery = true)
    List<Cinema> findDistinctCinemasBySponsoredName();
}
