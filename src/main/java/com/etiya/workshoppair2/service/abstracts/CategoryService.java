package com.etiya.workshoppair2.service.abstracts;

import com.etiya.workshoppair2.dto.category.*;
import com.etiya.workshoppair2.dto.product.*;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoryResponse> getAll();
    GetByIdCategoryResponse getById(int id);
    CreateCategoryResponse add(CreateCategoryRequest request);
    UpdateCategoryResponse update(UpdateCategoryRequest request);
    DeleteCategoryResponse delete(int id);
}
