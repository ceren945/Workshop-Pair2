package com.etiya.workshoppair2.mapper;

import com.etiya.workshoppair2.dto.category.*;
import com.etiya.workshoppair2.dto.product.*;
import com.etiya.workshoppair2.entity.Category;
import com.etiya.workshoppair2.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryFromCreateRequest(CreateCategoryRequest dto);

    CreateCategoryResponse categoryFromCreateResponse (Category category);

    Category categoryFromUpdateRequest(UpdateCategoryRequest request);

    UpdateCategoryResponse categoryFromUpdateResponse(Category category);

    List<GetAllCategoryResponse> categoryFromGetAllResponse(List<Category> categories);

    GetByIdCategoryResponse categoryFromGetByIdResponse(Category category);

    DeleteCategoryResponse categoryFromDeleteResponse(Category category);
}
