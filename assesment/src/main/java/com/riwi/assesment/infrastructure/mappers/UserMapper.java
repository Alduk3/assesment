package com.riwi.assesment.infrastructure.mappers;

import com.riwi.assesment.api.dto.request.UserRequest;
import com.riwi.assesment.api.dto.response.UserBasicResponse;
import com.riwi.assesment.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "histories", ignore = true)
    })
    User requestToEntity(UserRequest request);

    UserBasicResponse entityToResponse(User entityUser);
}
