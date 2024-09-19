package com.etiya.workshoppair2.dto.category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, message = "En az 3 karakter olmalı")
    private String name;

    @NotNull
    @NotBlank
    @Positive
    private int id;
}
