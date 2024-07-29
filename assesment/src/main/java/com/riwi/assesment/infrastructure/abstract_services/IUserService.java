package com.riwi.assesment.infrastructure.abstract_services;

import com.riwi.assesment.api.dto.request.UserRequest;
import com.riwi.assesment.api.dto.response.UserBasicResponse;

public interface IUserService extends Create<UserRequest, UserBasicResponse>,Delete<String>
        ,FindAll<UserBasicResponse>, FindById<UserBasicResponse,
                String>,Update<UserBasicResponse,UserRequest,String>{

    UserBasicResponse historyOfUserResponse(String id);
}
