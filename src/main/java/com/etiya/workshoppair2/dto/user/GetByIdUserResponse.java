package com.etiya.workshoppair2.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdUserResponse {
    private int id;
    private  String name;

    private String surname;
}
