package com.example.controller;

import com.example.model.Mentor;
import com.example.enums.Gender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String mentor(Model model) {

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mustafa", "Sahin", 27, Gender.MALE));
        mentorList.add(new Mentor("Mike", "Pence", 35, Gender.FEMALE));
        mentorList.add(new Mentor("Inavka", "Trump", 35, Gender.MALE));

        model.addAttribute("mentors", mentorList);

        return "mentor/mentor-list";
    }
}
