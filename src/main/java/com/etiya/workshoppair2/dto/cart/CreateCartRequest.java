package com.etiya.workshoppair2.dto.cart;

import com.etiya.workshoppair2.entity.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartRequest {

    private LocalDate createdDate;
    private int userId;
}
