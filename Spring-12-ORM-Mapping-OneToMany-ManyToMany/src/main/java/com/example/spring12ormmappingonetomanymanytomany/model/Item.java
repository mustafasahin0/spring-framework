package com.example.spring12ormmappingonetomanymanytomany.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item extends BaseEntity{

    private String name;
    private String code;

    @ManyToMany(mappedBy = "itemList")
    private List<Cart> cart;


    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
