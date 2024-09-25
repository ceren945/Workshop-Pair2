package com.etiya.workshoppair2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.management.ConstructorParameters;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //orm classı
@Table(name="products")
public class Product {
    @Id// bu tablonun pksı
    @GeneratedValue(strategy = GenerationType.IDENTITY) // bu değer auto verilecek db tarafından
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private BigDecimal unitPrice;

    @Column(name="stock")
    private int unitsInStock;

    @ManyToOne
    @JoinColumn(name="categoryid")
    private Category category; // her ürünün tek kategorisi var

    @OneToMany(mappedBy = "product")
    private List<ProductCart> productCarts;
}

