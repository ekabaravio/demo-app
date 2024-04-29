package com.demo.mapper;

import com.demo.dto.UserDto;
import com.demo.model.User;

public interface UserMapper {

    UserDto toUserDto(User user);
}