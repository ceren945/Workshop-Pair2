package com.etiya.workshoppair2.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductResponse {
    private int id;
    private String name;
    private BigDecimal unitPrice;
    private int unitsInStock;
}
