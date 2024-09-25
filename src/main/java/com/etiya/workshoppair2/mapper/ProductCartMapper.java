package com.etiya.workshoppair2.mapper;

import com.etiya.workshoppair2.dto.cart.*;
import com.etiya.workshoppair2.dto.productCart.*;
import com.etiya.workshoppair2.entity.Cart;
import com.etiya.workshoppair2.entity.ProductCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductCartMapper {
    ProductCartMapper INSTANCE = Mappers.getMapper(ProductCartMapper.class);

    List<GetAllProductCartResponse> productCartFromGetAllResponse (List<ProductCart> productCarts);

    GetByIdProductCartResponse productCartFromGetByIdResponse(ProductCart productCarts);

    CreateProductCartResponse productCartFromCreateResponse (ProductCart productCarts);

    UpdateProductCartResponse productCartFromUpdateResponse (ProductCart productCarts);

    DeleteProductCartResponse productCartFromDeleteResponse(ProductCart productCarts);

    ProductCart productCartFromCreateRequest(CreateProductCartRequest request);

    ProductCart productCartFromUpdateRequest(UpdateProductCartRequest request);
}
