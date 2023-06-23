package com.testincode.company.service.impl;

import com.testincode.company.dto.request.UserRequestDto;
import com.testincode.company.dto.response.UserResponseDto;
import com.testincode.company.exception.DataProcessingException;
import com.testincode.company.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.testincode.company.model.User;
import org.springframework.stereotype.Service;
import com.testincode.company.service.UserService;
import com.testincode.company.util.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.mapRequestDtoToEntity(userRequestDto);
        userRepository.save(user);

        return userMapper.mapEntityToDto(user);
    }

    @Override
    public UserResponseDto getById(Long id) {
        Optional<User> userFromDB = userRepository.findById(id);
        if (userFromDB.isPresent()) {
            return userMapper.mapEntityToDto(userFromDB.get());
        } else {
            log.error("User with id " + " not found");
            throw new DataProcessingException("Can't find user with id " + id);
        }
    }

    @Override
    public List<UserResponseDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDto> usersFromDb = new ArrayList<>();
        for (User user : userList) {
            usersFromDb.add(userMapper.mapEntityToDto(user));
        }
        return usersFromDb;
    }

    @Override
    public UserResponseDto editUserById(Long id, UserRequestDto userRequestDto) {
        Optional<User> userFromDB = userRepository.findById(id);
        if (userFromDB.isPresent()) {
            User updateUser = new User(id, userRequestDto.getName(), userRequestDto.getEmail());
            userRepository.save(updateUser);

            return userMapper.mapEntityToDto(updateUser);
        } else {
            log.error("User with id " + " not found");
            throw new DataProcessingException("Can't edit user with id " + id);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
