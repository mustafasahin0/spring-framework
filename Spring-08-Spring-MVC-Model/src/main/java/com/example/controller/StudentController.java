package com.example.controller;

import com.example.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model) {

        // Model Methods
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        String subject = "Collections";
        model.addAttribute("subject", subject);

        Random random = new Random();
        int studentId = random.nextInt();
        model.addAttribute("studentId", studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(10);
        model.addAttribute("numbers", numbers);

        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);

        return "/student/welcome";
    }
}
