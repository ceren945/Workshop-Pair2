package com.etiya.workshoppair2.dto.cart;

import com.etiya.workshoppair2.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCartResponse {
    private int id;
    private LocalDate createdDate;

}
