package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "regions")
public class Region extends BaseEntity{

    private String region;
    private String country;
}
