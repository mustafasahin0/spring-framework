package com.example.repository;

import com.example.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepository extends JpaRepository<Genre, Long> {

//    // ------------------- DERIVED QUERIES ------------------- //
//
//    //Write a JPQL query that return all genres
//    @Query("SELECT g FROM Genre g")
//    List<Genre> fetchAllJPQL();
//
//    // ------------------- Native QUERIES ------------------- //
//
//    //Write a native query that returns genres by containing name
//    @Query(value = "SELECT * FROM genre WHERE name ILIKE concat('%',?1,'%')",nativeQuery = true)
//    List<Genre> retrieveByName(String name);

    @Query(value = "SELECT count(*) from genre g JOIN movie_genre_rel mgr on g.id = mgr.genre_id WHERE g.id = ?1", nativeQuery = true)
    Integer countGenresNativeQuery(Long id);
}
