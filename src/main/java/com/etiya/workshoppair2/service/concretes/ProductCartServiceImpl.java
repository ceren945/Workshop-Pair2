package com.etiya.workshoppair2.service.concretes;

import com.etiya.workshoppair2.dto.productCart.*;
import com.etiya.workshoppair2.entity.Product;
import com.etiya.workshoppair2.entity.ProductCart;
import com.etiya.workshoppair2.mapper.ProductCartMapper;
import com.etiya.workshoppair2.mapper.ProductMapper;
import com.etiya.workshoppair2.repository.abstracts.ProductCartRepository;
import com.etiya.workshoppair2.service.abstracts.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCartServiceImpl implements ProductCartService {

    @Autowired
    private ProductCartRepository productCartRepository;

    @Override
    public List<GetAllProductCartResponse> getAll() {
       List<ProductCart> productCarts = productCartRepository.findAll();
       return ProductCartMapper.INSTANCE.productCartFromGetAllResponse(productCarts);
    }

    @Override
    public GetByIdProductCartResponse getById(int id) {
        ProductCart productCart = productCartRepository.findById(id).orElseThrow();
        return ProductCartMapper.INSTANCE.productCartFromGetByIdResponse(productCart);
    }

    @Override
    public CreateProductCartResponse add(CreateProductCartRequest request) {
        ProductCart productCart = ProductCartMapper.INSTANCE.productCartFromCreateRequest(request);
        productCartRepository.save(productCart);
        return ProductCartMapper.INSTANCE.productCartFromCreateResponse(productCart);
    }

    @Override
    public UpdateProductCartResponse update(UpdateProductCartRequest request) {
        ProductCart productCart = ProductCartMapper.INSTANCE.productCartFromUpdateRequest(request);
        productCartRepository.save(productCart);
        return ProductCartMapper.INSTANCE.productCartFromUpdateResponse(productCart);
    }

    @Override
    public DeleteProductCartResponse delete(int id) {
        ProductCart productCart = productCartRepository.findById(id).orElseThrow();
        productCartRepository.delete(productCart);
        return ProductCartMapper.INSTANCE.productCartFromDeleteResponse(productCart);
    }
}
