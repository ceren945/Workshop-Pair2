package com.etiya.workshoppair2.dto.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    @NotNull
    @Positive
    private int id;

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String name;

    @NotNull
    @PositiveOrZero
    private BigDecimal unitPrice;

    @NotNull
    @PositiveOrZero
    private int unitsInStock;
}
