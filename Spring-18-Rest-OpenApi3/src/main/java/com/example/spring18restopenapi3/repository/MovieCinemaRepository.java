package com.example.spring18restopenapi3.repository;

import com.example.spring18restopenapi3.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {
}
