package com.etiya.workshoppair2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id// bu tablonun pksı
    @GeneratedValue(strategy = GenerationType.IDENTITY) // bu değer auto verilecek db tarafından
    @Column(name="id")
    private int id;

    @Column(name="name")
    private  String name;

    @Column(name="surname")
    private String surname;

    @Column(name="identityno")
    private String identityNo;

    @OneToOne(mappedBy = "user")
    private Cart cart;
}
