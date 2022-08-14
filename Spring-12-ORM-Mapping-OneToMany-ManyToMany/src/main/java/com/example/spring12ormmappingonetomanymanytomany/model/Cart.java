package com.example.spring12ormmappingonetomanymanytomany.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
public class Cart extends BaseEntity {

    @ManyToMany
    private List<Item> itemList;
}
