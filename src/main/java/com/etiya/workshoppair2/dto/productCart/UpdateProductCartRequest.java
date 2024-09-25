package com.etiya.workshoppair2.dto.productCart;

import lombok.Data;

@Data
public class UpdateProductCartRequest {
    private int productId;
    private int cartId;
    private int quantity;
}
