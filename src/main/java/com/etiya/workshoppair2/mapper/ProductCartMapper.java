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

    // Target methodIsmi(Source s);
    // Target -> Mapping işleminde elde etmeyi hedeflediğim class
    // Source -> Target'a ulaşmak için kullandığım kaynak.
    // Eğer isimler aynı ise ekstra konfigürasyon gerekmez

    List<GetAllProductCartResponse> productCartFromGetAllResponse (List<ProductCart> productCarts);

    GetByIdProductCartResponse productCartFromGetByIdResponse(ProductCart productCarts);

    @Mapping(target = "productId", source="product.id")
    @Mapping(target = "cartId", source="cart.id")
    CreateProductCartResponse productCartFromCreateResponse (ProductCart productCarts);

    UpdateProductCartResponse productCartFromUpdateResponse (ProductCart productCarts);

    DeleteProductCartResponse productCartFromDeleteResponse(ProductCart productCarts);

    @Mapping(target = "id.productId", source="productId")
    @Mapping(target = "id.cartId", source="cartId")
    @Mapping(target = "product.id", source="productId")
    @Mapping(target = "cart.id", source="cartId")
    ProductCart productCartFromCreateRequest(CreateProductCartRequest request);

    ProductCart productCartFromUpdateRequest(UpdateProductCartRequest request);
}
