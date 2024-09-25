package com.etiya.workshoppair2.service.abstracts;

import com.etiya.workshoppair2.dto.user.*;


import java.util.List;

public interface UserService {
    List<GetAllUserResponse> getAll();
    GetByIdUserResponse getById(int id);
    CreateUserResponse add(CreateUserRequest request);
    UpdateUserResponse update(UpdateUserRequest request);
    DeleteUserResponse delete(int id);
}
