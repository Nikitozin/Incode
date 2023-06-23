package com.testincode.company.util.mapper;

import com.testincode.company.dto.request.UserRequestDto;
import com.testincode.company.dto.response.UserResponseDto;
import com.testincode.company.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapRequestDtoToEntity(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        return user;
    }

    public UserResponseDto mapEntityToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
