package com.etiya.workshoppair2.dto.cart;

import com.etiya.workshoppair2.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCartResponse {
    private int id;
    private User userId;
}
