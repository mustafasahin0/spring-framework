package com.example.spring18restopenapi3.controller;

import com.example.spring18restopenapi3.entity.Cinema;
import com.example.spring18restopenapi3.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Cinema", description = "Cinema CRUD Operations")
public class CinemaController {

    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/cinemas")
    @Operation(summary = "Read all cinemas")
    public List<Cinema> readAllCinemas() {
        return cinemaRepository.findAll();
    }
}
