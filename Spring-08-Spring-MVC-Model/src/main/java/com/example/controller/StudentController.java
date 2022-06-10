package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        // Model Methods
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        return "/student/welcome";
    }
}
