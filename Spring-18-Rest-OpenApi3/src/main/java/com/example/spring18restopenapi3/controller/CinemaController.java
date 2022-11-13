package com.example.spring18restopenapi3.controller;

import com.example.spring18restopenapi3.entity.Cinema;
import com.example.spring18restopenapi3.repository.CinemaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CinemaController {

    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/cinemas")
    public List<Cinema> readAllCinemas() {
        return cinemaRepository.findAll();
    }
}
