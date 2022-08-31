package com.example.repository;

import com.example.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    @Query("select g FROM Genre g")
    List<Genre> findAllGenres();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
    @Query(value = "SELECT * FROM GENRE WHERE NAME CONTAINS = ?1", nativeQuery = true)
    List<Genre> getGenreByName(String name);
}
