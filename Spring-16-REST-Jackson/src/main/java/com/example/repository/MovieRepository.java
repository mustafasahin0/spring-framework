package com.example.repository;

import com.example.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    //    // ------------------- DERIVED QUERIES ------------------- //
//
//    //Write a derived query to read a movie with a name
//    Optional<Movie> findByName(String name);
//
//    //Write a derived query to list all movies between a range of prices
//    List<Movie> findAllByPriceBetween(BigDecimal price1,BigDecimal price2);
//
//    //Write a derived query to list all movies where duration exists in the specific list of duration
//    List<Movie> findAllByDurationIn(List<Integer> durations);
//
//    //Write a derived query to list all movies with higher than a specific release date
//    List<Movie> findAllByReleaseDateAfter(LocalDate releaseDate);
//
//    //Write a derived query to list all movies with a specific state and type
//    List<Movie> findAllByStateAndType(MovieState movieState, MovieType movieType);
//
//    // ------------------- JPQL QUERIES ------------------- //
//
//    //Write a JPQL query to list all movies between a range of prices
//    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
//    List<Movie> fetchAllBetweenPricesRange(BigDecimal price1,BigDecimal price2);
//
//    //Write a JPQL query that returns all movie names
//    @Query("SELECT DISTINCT m.name FROM Movie m")
//    List<String> fetchAllMovieNames();
//
//    // ------------------- Native QUERIES ------------------- //
//
//    //Write a native query that returns a movie by name
//    @Query(value = "SELECT * FROM movie WHERE name = ?1",nativeQuery = true)
//    Optional<Movie> retrieveByName(String name);
//
//    //Write a native query that return the list of movies in a specific range of prices
//    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2",nativeQuery = true)
//    List<Movie> retrieveByPriceRange(BigDecimal price1,BigDecimal price2);
//
//    //Write a native query to return all movies where duration exists in the range of duration
//    @Query(value = "SELECT * FROM movie WHERE duration IN ?1",nativeQuery = true)
//    List<Movie> retrieveByDurationInRange(List<Integer> durations);
//
//    //Write a native query to list the top 5 most expensive movies
//    @Query(value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5",nativeQuery = true)
//    List<Movie> top5ExpensiveMovie();

}
