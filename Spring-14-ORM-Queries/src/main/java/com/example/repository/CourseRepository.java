package com.example.repository;

import com.example.entity.Course;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //find all courses by category
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name;
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the provided name exists. Return true, if course exist, false otherwise
    boolean existsByName(String name);

    // return the count of courses for the provided category
    int countByCategory(String category);

    //find all courses that start with the provided course name
    List<Course> findByNameStartsWith(String name);

    //find All Courses By Category And Returns A Stream
    Stream<Course> streamByCategory(String category);
}
