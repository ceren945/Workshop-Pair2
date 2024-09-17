package com.etiya.workshoppair2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.management.ConstructorParameters;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double unitPrice;
    private int unitsInStock;
}
