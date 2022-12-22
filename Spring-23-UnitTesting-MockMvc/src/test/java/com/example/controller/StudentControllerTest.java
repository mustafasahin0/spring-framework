package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    StudentService studentService;

    @Test
    void getStudent_test() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/student")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20}"))
                .andReturn();
    }

    @Test
    void jsonAssert() throws JSONException {

        String expected = "{\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\"}";
        String actual = "{\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20}";

        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    void getStudent_service() throws Exception {

        when(studentService.getStudent()).thenReturn(Arrays.asList(
                new Student("John", "Doe", 20),
                new Student("Tom", "Hanks", 50)
        ));

        mvc.perform(MockMvcRequestBuilders.get("/service/student").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\": 0, \"firstName\":  \"John\", \"lastName\": \"Doe\", \"age\": 20}, {\"id\": 0, \"firstName\":  \"Tom\", \"lastName\": \"Hanks\", \"age\": 50}]"))
                .andReturn();
    }

}