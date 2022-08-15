package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_account")
@Data
@NoArgsConstructor
public class User extends BaseEntity{


}
