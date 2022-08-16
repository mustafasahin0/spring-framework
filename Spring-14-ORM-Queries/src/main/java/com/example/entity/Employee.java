package com.example.entity;

import com.example.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @ManyToOne
    private Region region;
}
