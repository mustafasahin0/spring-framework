package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Organization {

    public Long id;
    public String name;
    public String contactName;
    public String contactEmail;
    public String contactPhone;

}
