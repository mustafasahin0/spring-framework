package com.example.spring18restopenapi3.controller;

import com.example.spring18restopenapi3.entity.Account;
import com.example.spring18restopenapi3.entity.Cinema;
import com.example.spring18restopenapi3.entity.User;
import com.example.spring18restopenapi3.repository.AccountRepository;
import com.example.spring18restopenapi3.repository.CinemaRepository;
import com.example.spring18restopenapi3.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

}
