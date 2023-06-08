package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.PasswordDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserRequestDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserUpdateDTO;
import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;
import io.github.brunoonofre64.dslist.domain.entities.UserEntity;
import io.github.brunoonofre64.dslist.domain.exceptions.InvalidPasswordException;
import io.github.brunoonofre64.dslist.domain.exceptions.RoleEmptyException;
import io.github.brunoonofre64.dslist.domain.exceptions.UserListIsEmpty;
import io.github.brunoonofre64.dslist.domain.exceptions.UsernameAlreadyExists;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.RoleRepository;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.UserRepository;
import io.github.brunoonofre64.dslist.stubs.RoleStub;
import io.github.brunoonofre64.dslist.stubs.UserStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.INDEX_ZERO;
import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.TEXT_DEFAULT;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    private UserEntity userEntity;
    private UserRequestDTO userRequestDTO;
    private UserUpdateDTO userUpdateDTO;
    private PasswordDTO passwordDTO;
    private RoleEntity roleEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, roleRepository, passwordEncoder);
        this.buildArrangeOfTests();
    }

    UserStub userStub = new UserStub();
    RoleStub roleStub = new RoleStub();

    @Test
    @DisplayName("Must save user with success")
    void mustSaveUserWithSuccess() {
        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(roleRepository.findByIdIn(anyList())).thenReturn(List.of(roleEntity));
        when(passwordEncoder.encode(any())).thenReturn(TEXT_DEFAULT);
        when(userRepository.save(any())).thenReturn(userEntity);

        UserDTO response = userService.save(userRequestDTO);

        assertNotNull(response);
        assertEquals(TEXT_DEFAULT, response.getEmail());
    }

    @Test
    @DisplayName("Must throw an error by email already exists")
    void mustThrowErrorByEmailAlreadyExists() {
        when(userRepository.existsByEmail(anyString())).thenReturn(true);

        Throwable ex = assertThrows(UsernameAlreadyExists.class,
                () -> userService.save(userRequestDTO));

        assertEquals(UsernameAlreadyExists.class, ex.getClass());
    }

    @Test
    @DisplayName("Must throw an error by role not found")
    void mustThrowErrorByRoleNotFound() {
        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(roleRepository.findByIdIn(anyList())).thenReturn(Collections.emptyList());

        Throwable ex = assertThrows(RoleEmptyException.class,
                () -> userService.save(userRequestDTO));

        assertEquals(RoleEmptyException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must update user with success")
    void mustUpdateUserWithSuccess() {
        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.ofNullable(userEntity));
        when(roleRepository.findByIdIn(anyList())).thenReturn(List.of(roleEntity));
        when(passwordEncoder.matches(any(), anyString())).thenReturn(true);
        when(passwordEncoder.encode(any())).thenReturn(TEXT_DEFAULT);
        when(userRepository.save(any())).thenReturn(userEntity);

        UserDTO response = userService.update(TEXT_DEFAULT, userUpdateDTO);

        assertNotNull(response);
        assertEquals(TEXT_DEFAULT, response.getEmail());
    }

    @Test
    @DisplayName("Must throw an error by update email already exists")
    void mustThrowErrorByUpdateEmailAlreadyExists() {
        when(userRepository.existsByEmail(anyString())).thenReturn(true);

        Throwable ex = assertThrows(UsernameAlreadyExists.class,
                () -> userService.update(TEXT_DEFAULT, userUpdateDTO));

        assertEquals(UsernameAlreadyExists.class, ex.getClass());
    }

    @Test
    @DisplayName("Must throw an error by update user not found")
    void mustThrowErrorByUpdateUserNotFound() {
        when(userRepository.existsByEmail(anyString())).thenReturn(false);

        Throwable ex = assertThrows(UsernameNotFoundException.class,
                () -> userService.update(TEXT_DEFAULT, userUpdateDTO));

        assertEquals(UsernameNotFoundException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must throw an error by update role not found")
    void mustThrowErrorByUpdateRoleNotFound() {
        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.ofNullable(userEntity));

        Throwable ex = assertThrows(RoleEmptyException.class,
                () -> userService.update(TEXT_DEFAULT, userUpdateDTO));

        assertEquals(RoleEmptyException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must throw an error by invalid current password")
    void mustThrowErrorByInvalidCurrentPassword() {
        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.ofNullable(userEntity));
        when(roleRepository.findByIdIn(anyList())).thenReturn(List.of(roleEntity));
        when(passwordEncoder.matches(any(), anyString())).thenReturn(false);

        Throwable ex = assertThrows(InvalidPasswordException.class,
                () -> userService.update(TEXT_DEFAULT, userUpdateDTO));

        assertEquals(InvalidPasswordException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must delete user with success")
    void mustDeleteUserWithSuccess() {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.ofNullable(userEntity));
        when(passwordEncoder.matches(any(), anyString())).thenReturn(true);

        userRepository.delete(userEntity);

        verify(userRepository).delete(userEntity);
        verify(userRepository, times(1)).delete(userEntity);
        verify(userRepository, atLeastOnce()).delete(userEntity);
    }

    @Test
    @DisplayName("Must throw an error by delete user not found")
    void mustThrowErrorByDeleteUserNotFound() {
        Throwable ex = assertThrows(UsernameNotFoundException.class,
                () -> userService.delete(TEXT_DEFAULT, passwordDTO));

        assertEquals(UsernameNotFoundException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must throw an error by delete with invalid current password")
    void mustThrowErrorByDeleteWIthInvalidCurrentPassword() {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.ofNullable(userEntity));
        when(passwordEncoder.matches(any(), anyString())).thenReturn(false);

        Throwable ex = assertThrows(InvalidPasswordException.class,
                () -> userService.delete(TEXT_DEFAULT, passwordDTO));

        assertEquals(InvalidPasswordException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must find all user with success")
    void mustFindAllUserWithSuccess() {
        when(userRepository.findAll()).thenReturn(List.of(userEntity));

        List<UserDTO> response = userService.findAll();

        assertNotNull(response);
        assertEquals(TEXT_DEFAULT, response.get(INDEX_ZERO).getEmail());
    }

    @Test
    @DisplayName("Must throw an error by user list is empty")
    void mustThrowErrorByUserListIsEmpty() {
        Throwable ex = assertThrows(UserListIsEmpty.class,
                () -> userService.findAll());

        assertEquals(UserListIsEmpty.class, ex.getClass());
    }

    private void buildArrangeOfTests() {
        userEntity = userStub.buildUserEntity();
        userRequestDTO = userStub.buildUserRequestDTO();
        userUpdateDTO = userStub.buildUserUpdateDTO();
        passwordDTO = userStub.buildPasswordDTO();
        roleEntity = roleStub.buildRoleEntity();
    }
}

