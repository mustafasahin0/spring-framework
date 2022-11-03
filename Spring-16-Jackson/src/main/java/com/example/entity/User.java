package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
public class User extends BaseEntity {

    private String email;

    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    private Account account;

}
