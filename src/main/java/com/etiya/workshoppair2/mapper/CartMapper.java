package com.etiya.workshoppair2.mapper;

import com.etiya.workshoppair2.dto.cart.*;
import com.etiya.workshoppair2.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    List<GetAllCartResponse> cartFromGetAllResponse (List<Cart> carts);

    GetByIdCartResponse cartFromGetByIdResponse(Cart cart);

    CreateCartResponse cartFromCreateResponse (Cart cart);

    UpdateCartResponse cartFromUpdateResponse (Cart cart);

    DeleteCartResponse cartFromDeleteResponse(Cart cart);


    Cart cartFromCreateRequest(CreateCartRequest request);

    Cart cartFromUpdateRequest(UpdateCartRequest request);
}
