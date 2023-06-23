package com.testincode.company.controller;

import com.testincode.company.dto.request.UserRequestDto;
import com.testincode.company.dto.response.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.testincode.company.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public List<UserResponseDto> getAllUsers() {
        log.debug("Get all users");
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable("id") Long id) {
        log.debug("Get user by id: {}", id);
        return userService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody @Validated UserRequestDto userRequestDto) {
        UserResponseDto createdUser = userService.createUser(userRequestDto);
        log.debug("Create new user with id: {}", createdUser.getId());
        return createdUser;
    }

    @PutMapping("/{id}")
    public UserResponseDto editUserById(@PathVariable("id") Long id,
                                        @RequestBody @Validated UserRequestDto userRequestDto) {
        log.debug("Update user with id: {}", id);
        return userService.editUserById(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }
}
