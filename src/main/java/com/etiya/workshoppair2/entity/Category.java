package com.etiya.workshoppair2.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")

public class Category {

    @Id// bu tablonun pksı
    @GeneratedValue(strategy = GenerationType.IDENTITY) // bu değer auto verilecek db tarafından
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products; // her kategorinin birden çok ürünü var

}
