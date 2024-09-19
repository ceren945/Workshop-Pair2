package com.etiya.workshoppair2.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductResponse {
    private int id;
    private String name;
    private double unitPrice;
    private int categoryId;
}
