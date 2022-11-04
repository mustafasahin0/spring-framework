package com.example.controller;

import com.example.dto.CourseDTO;
import com.example.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // @Controller + @ResponseBody
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId) {

        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category) {

        return courseService.getCoursesByCategory(category);
    }

}
