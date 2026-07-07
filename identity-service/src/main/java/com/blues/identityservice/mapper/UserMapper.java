package com.blues.identityservice.mapper;

import com.blues.identityservice.dto.response.UserResponse;
import com.blues.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface UserMapper {
    UserResponse toUserResponse(User user);
}
