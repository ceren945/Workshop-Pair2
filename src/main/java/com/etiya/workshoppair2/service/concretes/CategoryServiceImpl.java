package com.etiya.workshoppair2.service.concretes;

import com.etiya.workshoppair2.core.exception.type.BusinessException;
import com.etiya.workshoppair2.dto.category.*;
import com.etiya.workshoppair2.dto.product.GetAllProductResponse;
import com.etiya.workshoppair2.entity.Category;
import com.etiya.workshoppair2.entity.Product;
import com.etiya.workshoppair2.mapper.CategoryMapper;
import com.etiya.workshoppair2.mapper.ProductMapper;
import com.etiya.workshoppair2.repository.abstracts.CategoryRepository;
import com.etiya.workshoppair2.repository.abstracts.ProductRepository;
import com.etiya.workshoppair2.service.abstracts.CategoryService;
import com.etiya.workshoppair2.service.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;

    @Override
    public List<GetAllCategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return CategoryMapper.INSTANCE.categoryFromGetAllResponse(categories);
    }

    @Override
    public GetByIdCategoryResponse getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return CategoryMapper.INSTANCE.categoryFromGetByIdResponse(category);
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {

        Category category = CategoryMapper.INSTANCE.categoryFromCreateRequest(request);


        boolean categoryWithSameName = categoryRepository.findAll()
                .stream()
                .anyMatch(c -> c.getName().equals(category.getName()));

        if(categoryWithSameName)
            throw new BusinessException("Böyle bir kategori zaten var");

        categoryRepository.save(category);
        return CategoryMapper.INSTANCE.categoryFromCreateResponse(category);
    }

    @Override
    public UpdateCategoryResponse update(UpdateCategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.categoryFromUpdateRequest(request);
        categoryRepository.save(category);

        return CategoryMapper.INSTANCE.categoryFromUpdateResponse(category);
    }


    @Override
    public DeleteCategoryResponse delete(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(category);
        return CategoryMapper.INSTANCE.categoryFromDeleteResponse(category);
    }
}
