package com.etiya.workshoppair2.service.abstracts;

import com.etiya.workshoppair2.dto.cart.*;
import com.etiya.workshoppair2.dto.user.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
    List<GetAllCartResponse> getAll();
    GetByIdCartResponse getById(int id);
    CreateCartResponse add(CreateCartRequest request);
    UpdateCartResponse update(UpdateCartRequest request);
    DeleteCartResponse delete(int id);
}
