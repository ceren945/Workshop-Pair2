package com.etiya.workshoppair2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="carts")
public class Cart {
    @Id// bu tablonun pksı
    @GeneratedValue(strategy = GenerationType.IDENTITY) // bu değer auto verilecek db tarafından
    @Column(name="id")
    private int id;
    @Column(name="created_date")
    private LocalDate createdDate;

    @OneToOne
    @JoinColumn(name="user_id")
    private User userId;
}
