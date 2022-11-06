package com.example.repository;

import com.example.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {
    //    // ------------------- DERIVED QUERIES ------------------- //
//
//    //Write a derived query to read movie cinema with id
//    Optional<MovieCinema> findById(Long id);
//
//    //Write a derived query to count all movie cinemas with a specific cinema id
//    Integer countAllByCinemaId(Long cinemaId);
//
//    //Write a derived query to count all movie cinemas with a specific movie id
//    Integer countAllByMovieId(Integer movieId);
//
//    //Write a derived query to list all movie cinemas with higher than a specific date
//    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime dateTime);
//
//    //Write a derived query to find the top 3 expensive movies
//    List<MovieCinema> findFirst3ByOrderByMoviePriceAsc();
//
//    //Write a derived query to list all movie cinemas that contain a specific movie name
//    List<MovieCinema> findAllByMovieNameContaining(String name);
//
//    //Write a derived query to list all movie cinemas in a specific location
//    List<MovieCinema> findAllByCinemaLocationName(String name);
//
//    // ------------------- JPQL QUERIES ------------------- //
//
//    //Write a JPQL query to list all movie cinemas with after a specific date
//
//    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime > ?1")
//    List<MovieCinema> fetchAllWithHigherSpecificDateJPQL(LocalDateTime dateTime);
//
//    // ------------------- Native QUERIES ------------------- //
//
//    //Write a native query to count all movie cinemas by cinema id
//    @Query(value = "SELECT count(*) FROM movie_cinema WHERE cinema_id = ?1 ",nativeQuery = true)
//    Integer countByCinemaIdNativeQuery(Long cinemaId);
//
//    //Write a native query that returns all movie cinemas by location name
//    @Query(value = "SELECT * FROM movie_cinema JOIN cinema c on c.id = movie_cinema.cinema_id  JOIN location l on c.location_id=l.id WHERE l.name = ?1",nativeQuery = true)
//    List<MovieCinema> retrieveAllByLocationName(String locationName);
}
