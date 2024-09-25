package com.etiya.workshoppair2.service.concretes;

import com.etiya.workshoppair2.core.exception.type.BusinessException;
import com.etiya.workshoppair2.dto.cart.*;
import com.etiya.workshoppair2.entity.Cart;
import com.etiya.workshoppair2.entity.User;
import com.etiya.workshoppair2.mapper.CartMapper;
import com.etiya.workshoppair2.mapper.UserMapper;
import com.etiya.workshoppair2.repository.abstracts.CartRepository;
import com.etiya.workshoppair2.service.abstracts.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<GetAllCartResponse> getAll() {
        List<Cart> carts = cartRepository.findAll();
        return CartMapper.INSTANCE.cartFromGetAllResponse(carts);
    }

    @Override
    public GetByIdCartResponse getById(int id) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        return CartMapper.INSTANCE.cartFromGetByIdResponse(cart);
    }

    @Override
    public CreateCartResponse add(CreateCartRequest request) {
        Cart cart = CartMapper.INSTANCE.cartFromCreateRequest(request);

        cartRepository.save(cart);

        return CartMapper.INSTANCE.cartFromCreateResponse(cart);
    }

    @Override
    public UpdateCartResponse update(UpdateCartRequest request) {
        Cart cart = CartMapper.INSTANCE.cartFromUpdateRequest(request);
        cartRepository.save(cart);
        return CartMapper.INSTANCE.cartFromUpdateResponse(cart);
    }

    @Override
    public DeleteCartResponse delete(int id) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        cartRepository.delete(cart);
        return CartMapper.INSTANCE.cartFromDeleteResponse(cart);
    }
}
