package controller;

import com.testincode.company.controller.UserController;
import com.testincode.company.dto.request.UserRequestDto;
import com.testincode.company.dto.response.UserResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.testincode.company.service.UserService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllUsers_ShouldReturnListOfUsers() {
        List<UserResponseDto> expectedUsers = Arrays.asList(
                new UserResponseDto(1L, "John", "john@example.com"),
                new UserResponseDto(2L, "Alice", "alice@example.com")
        );
        when(userService.getAll()).thenReturn(expectedUsers);
        List<UserResponseDto> actualUsers = userController.getAllUsers();
        assertEquals(expectedUsers.size(), actualUsers.size());
        assertEquals(expectedUsers.get(0).getId(), actualUsers.get(0).getId());
        assertEquals(expectedUsers.get(0).getName(), actualUsers.get(0).getName());
        assertEquals(expectedUsers.get(0).getEmail(), actualUsers.get(0).getEmail());
    }

    @Test
    void getUserById_ShouldReturnUserWithGivenId() {
        long userId = 1L;
        UserResponseDto expectedUser = new UserResponseDto(userId, "John", "john@example.com");
        when(userService.getById(userId)).thenReturn(expectedUser);
        UserResponseDto actualUser = userController.getUserById(userId);
        assertEquals(expectedUser.getId(), actualUser.getId());
        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }

    @Test
    void createUser_ShouldReturnCreatedUser() {
        UserRequestDto userRequestDto = new UserRequestDto("John", "john@example.com");
        UserResponseDto expectedUser = new UserResponseDto(1L, "John", "john@example.com");
        when(userService.createUser(userRequestDto)).thenReturn(expectedUser);
        UserResponseDto actualUser = userController.createUser(userRequestDto);
        assertEquals(expectedUser.getId(), actualUser.getId());
        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }

    @Test
    void editUserById_ShouldReturnUpdatedUser() {
        long userId = 1L;
        UserRequestDto userRequestDto = new UserRequestDto("Alice", "alice@example.com");
        UserResponseDto expectedUser = new UserResponseDto(userId, "Alice", "alice@example.com");
        when(userService.editUserById(userId, userRequestDto)).thenReturn(expectedUser);
        UserResponseDto actualUser = userController.editUserById(userId, userRequestDto);
        assertEquals(expectedUser.getId(), actualUser.getId());
        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }

    @Test
    void deleteUserById_ShouldCallUserServiceToDeleteUser() {
        long userId = 1L;
        userController.deleteUserById(userId);
        verify(userService, times(1)).deleteUserById(userId);
    }
}