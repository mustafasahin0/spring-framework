package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourseDTO {

    private Long id;
    private String name;
    private String category;
    private int rating;
    private String description;
}
