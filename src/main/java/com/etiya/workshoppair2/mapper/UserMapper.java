package com.etiya.workshoppair2.mapper;

import com.etiya.workshoppair2.dto.user.*;
import com.etiya.workshoppair2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<GetAllUserResponse> userFromGetAllResponse(List<User> users);

    GetByIdUserResponse userFromGetByIdResponse(User user);

    User userFromCreateRequest(CreateUserRequest request);

    CreateUserResponse userFromCreateResponse(User user);

    User userFromUpdateRequest(UpdateUserRequest request);

    UpdateUserResponse userFromUpdateResponse(User user);

    DeleteUserResponse userFromDeleteResponse(User user);
}
