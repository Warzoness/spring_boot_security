package com.dayoungapplication.mapper;

import com.dayoungapplication.dto.request.UserUpdateRequest;
import com.dayoungapplication.dto.response.UserResponse;
import org.mapstruct.Mapper;

import com.dayoungapplication.dto.request.UserCreationRequest;
import com.dayoungapplication.entity.User;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
