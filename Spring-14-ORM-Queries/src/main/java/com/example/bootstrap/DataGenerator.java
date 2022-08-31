package com.example.bootstrap;

import com.example.repository.CourseRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        System.out.println("------------- REGION START -----------------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findByDistinctCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTopByCountry: " + regionRepository.findTop2ByCountry("Asia"));


        System.out.println("------------- REGION END -----------------");
        System.out.println("------------- DEPARTMENT START -----------------");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("------------- DEPARTMENT END -----------------");

        System.out.println("------------- EMPLOYEE START -----------------");
        System.out.println("getEmployeeDetail: " + employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary: " + employeeRepository.getEmployeeSalary());


        System.out.println("------------- EMPLOYEE END -----------------");
        System.out.println("------------- COURSE START -----------------");

        courseRepository.findByCategory("Spring").forEach(System.out::println);
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println("courseRepository.existsByName(\"Spring\") = " + courseRepository.existsByName("Spring"));
        System.out.println(courseRepository.countByCategory("Spring"));
        System.out.println(courseRepository.findByNameStartsWith("Scalable"));

        //  courseRepository.streamByCategory("Spring").forEach(System.out::println);
        courseRepository.streamByCategory("Spring").forEach(System.out::println);


        System.out.println("------------- COURSE END -----------------");


    }
}
