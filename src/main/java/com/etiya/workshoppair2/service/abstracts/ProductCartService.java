package com.etiya.workshoppair2.service.abstracts;

import com.etiya.workshoppair2.dto.category.*;
import com.etiya.workshoppair2.dto.productCart.*;

import java.util.List;

public interface ProductCartService {

    List<GetAllProductCartResponse> getAll();
    GetByIdProductCartResponse getById(int id);
    CreateProductCartResponse add(CreateProductCartRequest request);
    UpdateProductCartResponse update(UpdateProductCartRequest request);
    DeleteProductCartResponse delete(int id);
}
