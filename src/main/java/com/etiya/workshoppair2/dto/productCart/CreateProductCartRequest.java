package com.etiya.workshoppair2.dto.productCart;

import lombok.Data;

@Data
public class CreateProductCartRequest {
    private int productId;
    private int cartId;
    private int quantity;
}
