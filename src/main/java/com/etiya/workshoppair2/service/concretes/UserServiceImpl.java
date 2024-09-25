package com.etiya.workshoppair2.service.concretes;

import com.etiya.workshoppair2.core.exception.type.BusinessException;
import com.etiya.workshoppair2.dto.user.*;
import com.etiya.workshoppair2.entity.Product;
import com.etiya.workshoppair2.entity.User;
import com.etiya.workshoppair2.mapper.ProductMapper;
import com.etiya.workshoppair2.mapper.UserMapper;
import com.etiya.workshoppair2.repository.abstracts.UserRepository;
import com.etiya.workshoppair2.service.abstracts.UserService;
import com.fasterxml.jackson.datatype.jdk8.DoubleStreamSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.userFromGetAllResponse(users);
    }

    @Override
    public GetByIdUserResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        return UserMapper.INSTANCE.userFromGetByIdResponse(user);
    }

    @Override
    public CreateUserResponse add(CreateUserRequest request) {
        User user = UserMapper.INSTANCE.userFromCreateRequest(request);


        userRepository.save(user);

        return UserMapper.INSTANCE.userFromCreateResponse(user);
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {

        User user = UserMapper.INSTANCE.userFromUpdateRequest(request);
        userRepository.save(user);
        return UserMapper.INSTANCE.userFromUpdateResponse(user);
    }

    @Override
    public DeleteUserResponse delete(int id) {
        User user = userRepository.findById(id).orElseThrow();

        if(user == null)
            throw new BusinessException("Kullanıcı Bulunamadı");

        userRepository.delete(user);
        return UserMapper.INSTANCE.userFromDeleteResponse(user);
    }
}
