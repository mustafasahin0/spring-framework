package com.example.service.impl;

import com.example.dto.CourseDTO;
import com.example.entity.Course;
import com.example.repository.CourseRepository;
import com.example.service.CourseService;
import com.example.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CourseDTO createCourse(CourseDTO course) {

        courseRepository.save(mapperUtil.convert(course, new Course()));

        return course;
    }

    @Override
    public CourseDTO getCourseById(long courseId) {

        Course course = courseRepository.findById(courseId).get();

        return mapperUtil.convert(course, new CourseDTO());
    }

    @Override
    public List<CourseDTO> getCoursesByCategory(String category) {

        List<Course> list = courseRepository.findAllByCategory(category);
        return list.stream().map(obj -> mapperUtil.convert(obj, new CourseDTO())).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourses() {
        List<Course> list = courseRepository.findAll();

        return list.stream().map(obj -> mapperUtil.convert(obj, new CourseDTO())).collect(Collectors.toList());
    }

    @Override
    public void updateCourse(Long courseId, CourseDTO courseDTO) {

        Course course = mapperUtil.convert(courseDTO, new Course());

        courseRepository.findById(courseId).ifPresent(dbCourse -> {
            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setDescription(course.getDescription());
            dbCourse.setRating(course.getRating());

            courseRepository.save(dbCourse);
        });
    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();
    }

    @Override
    public void deleteCourseById(long courseId) {
        courseRepository.deleteById(courseId);
    }
}
