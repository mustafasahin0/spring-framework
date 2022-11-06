package com.example.repository;

import com.example.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    //    // ------------------- DERIVED QUERIES ------------------- //
//
//    //Write a derived query to get cinema with a specific name
//    Optional<Cinema> findByName(String name);
//
//    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
//    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredNameAsc(String sponsoredname);
//
//    //Write a derived query to list all cinemas in a specific country
//    List<Cinema> findAllByLocationCountry(String country);
//
//    //Write a derived query to list all cinemas with a specific name or sponsored name
//    List<Cinema> findAllByNameOrSponsoredName(String name,String sponsoredname);
//
//
//    // ------------------- JPQL QUERIES ------------------- //
//
//    //Write a JPQL query to read the cinema name with a specific id
//    @Query("SELECT c.name FROM Cinema c WHERE c.id=?1")
//    String fetchByIdJPQL(Integer id);
//
//    // ------------------- Native QUERIES ------------------- //
//
//    //Write a native query to read all cinemas by location country
//    @Query(value = "SELECT * FROM cinema c JOIN location l on l.id=c.location_id WHERE l.country=?1",nativeQuery = true)
//    List<Cinema> retrieveAllByLocationCountry(String locationCountry);
//
//    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
//    @Query(value = "SELECT * FROM cinema WHERE name ILIKE concat('%',?1,'%') OR sponsored_name ILIKE concat('%',?1,'%')",nativeQuery = true )
//    List<Cinema> retrieveAllByNameOrSponsoredName(String pattern);
//
//    //Write a native query to sort all cinemas by name
//    @Query(value = "SELECT * FROM cinema ORDER BY name",nativeQuery = true)
//    List<Cinema> sortByName();
//
//    //Write a native query to distinct all cinemas by sponsored name
//    @Query(value = "SELECT DISTINCT sponsored_name FROM cinema",nativeQuery = true)
//    List<String> distinctBYSponsoredName();
}
