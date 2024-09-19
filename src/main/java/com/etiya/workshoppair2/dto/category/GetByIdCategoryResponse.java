package com.etiya.workshoppair2.dto.category;
import com.etiya.workshoppair2.dto.product.GetAllProductResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCategoryResponse {
    private String name;
    private List<GetAllProductResponse> product;
}
