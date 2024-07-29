package com.riwi.assesment.infrastructure.services;

import com.riwi.assesment.api.dto.request.UserRequest;
import com.riwi.assesment.api.dto.response.UserBasicResponse;
import com.riwi.assesment.domain.entities.User;
import com.riwi.assesment.domain.repositories.UserRepository;
import com.riwi.assesment.infrastructure.abstract_services.IUserService;
import com.riwi.assesment.infrastructure.helpers.SupportServices;
import com.riwi.assesment.infrastructure.mappers.UserMapper;
import com.riwi.assesment.utils.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final SupportServices<User> supportServices;


    @Override
    public UserBasicResponse create(UserRequest userRequest) {
        User entityUser = this.userMapper.requestToEntity(userRequest);
        return this.userMapper.entityToResponse(this.userRepository.save(entityUser));
    }

    @Override
    public void delete(String id) {
        this.userRepository.delete(this.find(id));
    }

    @Override
    public Page<UserBasicResponse> getAll(int page, int size) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public UserBasicResponse getById(String id) {
        User userEntity = this.find(id);
        return this.userMapper.entityToResponse(userEntity);
    }

    @Override
    public UserBasicResponse update(UserRequest userRequest, String id) {
        User user = this.find(id);
        user = this.userMapper.requestToEntity(userRequest);
        user.setId(id);
        return this.userMapper.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserBasicResponse historyOfUserResponse(String id) {
        return null;
    }

    public User find(String id){
        return this.supportServices.findById(userRepository,id,"user");
    }
}
