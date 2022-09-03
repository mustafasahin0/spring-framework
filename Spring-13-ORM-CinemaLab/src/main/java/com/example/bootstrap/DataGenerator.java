package com.example.bootstrap;

import com.example.repository.AccountRepository;
import com.example.repository.CinemaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final CinemaRepository cinemaRepository;

    public DataGenerator(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------- START: ACCOUNT REPOSITORY ------------------- ");

        System.out.println("------------------- END: ACCOUNT REPOSITORY ------------------- ");

    }
}
