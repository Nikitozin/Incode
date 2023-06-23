package service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.testincode.company.dto.request.UserRequestDto;
import com.testincode.company.dto.response.UserResponseDto;
import com.testincode.company.exception.DataProcessingException;
import com.testincode.company.service.impl.UserServiceImpl;
import com.testincode.company.util.mapper.UserMapper;
import com.testincode.company.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.testincode.company.repository.UserRepository;
import com.testincode.company.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserMapper userMapper;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userMapper = new UserMapper();
        userService = new UserServiceImpl(userRepository, userMapper);
    }

    @Test
    public void createUser_ShouldSaveUserAndReturnResponseDto() {
        UserRequestDto userRequestDto = new UserRequestDto("John Doe", "john.doe@example.com");
        User user = userMapper.mapRequestDtoToEntity(userRequestDto);
        when(userRepository.save(any(User.class))).thenReturn(user);
        UserResponseDto createdUser = userService.createUser(userRequestDto);
        verify(userRepository, times(1)).save(user);
        assertNotNull(createdUser);
        assertEquals(user.getId(), createdUser.getId());
        assertEquals(user.getName(), createdUser.getName());
        assertEquals(user.getEmail(), createdUser.getEmail());
    }

    @Test
    public void getById_ExistingUserId_ShouldReturnUserResponseDto() {
        long userId = 1L;
        User user = new User(userId, "John Doe", "john.doe@example.com");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        UserResponseDto userResponseDto = userService.getById(userId);
        verify(userRepository, times(1)).findById(userId);
        assertNotNull(userResponseDto);
        assertEquals(user.getId(), userResponseDto.getId());
        assertEquals(user.getName(), userResponseDto.getName());
        assertEquals(user.getEmail(), userResponseDto.getEmail());
    }

    @Test
    public void getById_NonExistingUserId_ShouldThrowException() {
        long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(DataProcessingException.class, () -> userService.getById(userId));
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    public void getAll_ShouldReturnListOfUserResponseDto() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "John Doe", "john.doe@example.com"));
        userList.add(new User(2L, "Jane Smith", "jane.smith@example.com"));
        when(userRepository.findAll()).thenReturn(userList);
        List<UserResponseDto> userResponseList = userService.getAll();
        verify(userRepository, times(1)).findAll();
        assertNotNull(userResponseList);
        assertEquals(userList.size(), userResponseList.size());
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            UserResponseDto userResponseDto = userResponseList.get(i);
            assertEquals(user.getId(), userResponseDto.getId());
            assertEquals(user.getName(), userResponseDto.getName());
            assertEquals(user.getEmail(), userResponseDto.getEmail());
        }
    }

    @Test
    public void editUserById_ExistingUserId_ShouldSaveUserAndReturnUpdatedResponseDto() {
        long userId = 1L;
        UserRequestDto userRequestDto = new UserRequestDto("John Doe", "john.doe@example.com");
        User existingUser = new User(userId, "Old Name", "old.email@example.com");
        User updatedUser = new User(userId, userRequestDto.getName(), userRequestDto.getEmail());
        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);
        UserResponseDto updatedUserResponseDto = userService.editUserById(userId, userRequestDto);
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(updatedUser);
        assertNotNull(updatedUserResponseDto);
        assertEquals(updatedUser.getId(), updatedUserResponseDto.getId());
        assertEquals(updatedUser.getName(), updatedUserResponseDto.getName());
        assertEquals(updatedUser.getEmail(), updatedUserResponseDto.getEmail());
    }

    @Test
    public void editUserById_NonExistingUserId_ShouldThrowException() {
        long userId = 1L;
        UserRequestDto userRequestDto = new UserRequestDto("John Doe", "john.doe@example.com");
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(DataProcessingException.class, () -> userService.editUserById(userId, userRequestDto));
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void deleteUserById_ShouldDeleteUser() {
        long userId = 1L;
        userService.deleteUserById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }
}