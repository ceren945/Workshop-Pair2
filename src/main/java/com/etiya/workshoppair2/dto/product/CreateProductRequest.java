package com.etiya.workshoppair2.dto.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, message = "En az 3 karakter olmalı")
    private String name;

    @NotNull
    @PositiveOrZero
    private double unitPrice;

    @NotNull
    @PositiveOrZero
    private int unitsInStock;

    @NotNull
    @Positive
    private int categoryId;
}
