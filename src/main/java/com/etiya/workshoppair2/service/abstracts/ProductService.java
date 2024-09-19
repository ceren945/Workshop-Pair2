package com.etiya.workshoppair2.service.abstracts;

import com.etiya.workshoppair2.dto.product.*;
import com.etiya.workshoppair2.entity.Product;

import java.util.List;

public interface ProductService {
    List<GetAllProductResponse> getAll();
    GetByIdProductResponse getById(int id);
    CreateProductResponse add(CreateProductRequest request);
    UpdateProductResponse update(UpdateProductRequest request);
    DeleteProductResponse delete(int id);
}
