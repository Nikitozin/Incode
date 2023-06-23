package com.testincode.company.service;

import com.testincode.company.dto.request.UserRequestDto;
import com.testincode.company.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto getById(Long id);

    List<UserResponseDto> getAll();

    UserResponseDto editUserById(Long id, UserRequestDto userRequestDto);

    void deleteUserById(Long id);
}
