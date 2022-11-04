package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
public class User extends BaseEntity {

    @JsonIgnore
    private String email;


    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    @JsonManagedReference // is the forward part of reference - the one that gets serialized normally
    private Account account;

}
