package com.etiya.workshoppair2.service.concretes;

import com.etiya.workshoppair2.core.exception.type.BusinessException;
import com.etiya.workshoppair2.dto.category.GetAllCategoryResponse;
import com.etiya.workshoppair2.dto.product.*;
import com.etiya.workshoppair2.entity.Category;
import com.etiya.workshoppair2.entity.Product;
import com.etiya.workshoppair2.mapper.CategoryMapper;
import com.etiya.workshoppair2.mapper.ProductMapper;
import com.etiya.workshoppair2.repository.abstracts.CategoryRepository;
import com.etiya.workshoppair2.repository.abstracts.ProductRepository;
import com.etiya.workshoppair2.service.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private  ProductRepository productRepository;


    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        return ProductMapper.INSTANCE.productFromGetAllResponse(products);
    }

    @Override
    public GetByIdProductResponse getById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        return ProductMapper.INSTANCE.productFromGetByIdResponse(product);
    }


    @Override
    public CreateProductResponse add(CreateProductRequest request) {

        Product product = ProductMapper.INSTANCE.productFromCreateRequest(request);


        boolean productWithSameName = productRepository.findAll()
                .stream()
                .anyMatch(p -> p.getName().equals(product.getName()));

        if(productWithSameName)
            throw new BusinessException("Böyle bir ürün zaten var");



        productRepository.save(product);
       return ProductMapper.INSTANCE.productFromCreateResponse(product);
    }

    @Override
    public UpdateProductResponse update(UpdateProductRequest request) {
        Product oldProduct = productRepository.findById(request.getId()).orElseThrow();
        Product product = ProductMapper.INSTANCE.productFromUpdateRequest(request);

        if(request.getUnitsInStock() - oldProduct.getUnitsInStock() > 100)
            throw new BusinessException("Stok adedi tek seferde maksimum 100 adet artırılabilir");

        productRepository.save(product);
        return ProductMapper.INSTANCE.productFromUpdateResponse(product);
    }

    @Override
    public DeleteProductResponse delete(int id) {


        Product product = productRepository.findById(id).orElseThrow();

        if(product == null)
            throw new BusinessException("Ürün Bulunamadı");

        productRepository.delete(product);
        return ProductMapper.INSTANCE.productFromDeleteResponse(product);

    }
}
