package io.brunoonofre64.api.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.brunoonofre64.stubs.RoleStubIntegration;
import io.brunoonofre64.stubs.UserStubIntegration;
import io.github.brunoonofre64.dslist.DslistApplication;
import io.github.brunoonofre64.dslist.domain.dto.PasswordDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserUpdateDTO;
import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;
import io.github.brunoonofre64.dslist.domain.entities.UserEntity;
import io.github.brunoonofre64.dslist.domain.exceptions.InvalidPasswordException;
import io.github.brunoonofre64.dslist.domain.exceptions.RoleEmptyException;
import io.github.brunoonofre64.dslist.domain.exceptions.UserListIsEmpty;
import io.github.brunoonofre64.dslist.domain.exceptions.UsernameAlreadyExists;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.RoleRepository;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest(classes = DslistApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("TEST-H2")
@AutoConfigureMockMvc
class UserControllerTestIT extends IntegrationTestBase {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
        super.buildUserWithAuthorities();
    }

    UserStubIntegration userStub = new UserStubIntegration();
    RoleStubIntegration roleStub = new RoleStubIntegration();

    @Test
    @DisplayName("Must save user with success and return status created")
    void mustSaveUserWithSuccess() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        String requestBody = objectMapper.writeValueAsString(userStub.buildUserRequestDTO(List.of(role.getId())));

        mockMvc.perform(post(WEB_METHOD_TEST.V1_USER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value(USER_EMAIL))
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw an error by email already exists and return status bad request")
    void mustThrowErrorByEmailAlreadyExists() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        userRepository.save(userStub.buildUserEntity());
        String requestBody = objectMapper.writeValueAsString(userStub.buildUserRequestDTO(List.of(role.getId())));

        mockMvc.perform(post(WEB_METHOD_TEST.V1_USER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof UsernameAlreadyExists))
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw an error by role is empty and return status bad request")
    void mustThrowErrorByRoleIsEmpty() throws Exception {
        String requestBody = objectMapper.writeValueAsString(userStub.buildUserRequestDTO(Collections.emptyList()));

        mockMvc.perform(post(WEB_METHOD_TEST.V1_USER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof RoleEmptyException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must user with success and return status no content")
    void mustUpdateGameWithSuccess() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        UserEntity user = userStub.buildUserEntity();
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        String requestBody = objectMapper.writeValueAsString(userStub.buildUserRequestDTOUpdate(List.of(role.getId())));

        mockMvc.perform(put(WEB_METHOD_TEST.V1_USER
                        .concat(SLASH)
                        .concat(EMAIL_PARAM)
                        .concat(user.getEmail()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.email").value(GUEST_EMAIL))
                .andDo(print());

    }

    @Test
    @DisplayName("Must throw an error by update with email already existes and return status bad request")
    void mustThrowErrorByUpdateEmailAlreadyExists() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        UserEntity user = userStub.buildUserEntity();
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        UserUpdateDTO userUpdateDTO = userStub.buildUserRequestDTOUpdate(List.of(role.getId()));
        userUpdateDTO.setEmail(user.getEmail());

        String requestBody = objectMapper.writeValueAsString(userUpdateDTO);

        mockMvc.perform(put(WEB_METHOD_TEST.V1_USER
                        .concat(SLASH)
                        .concat(EMAIL_PARAM)
                        .concat(user.getEmail()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof UsernameAlreadyExists))
                .andDo(print());

    }

    @Test
    @DisplayName("Must throw an error by update by user not found and return status bad request")
    void mustThrowErrorByUpdateByUserNotFound() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        UserEntity user = userStub.buildUserEntity();
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        UserUpdateDTO userUpdateDTO = userStub.buildUserRequestDTOUpdate(List.of(role.getId()));

        String requestBody = objectMapper.writeValueAsString(userUpdateDTO);

        mockMvc.perform(put(WEB_METHOD_TEST.V1_USER
                        .concat(SLASH)
                        .concat(EMAIL_PARAM)
                        .concat("x"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof UsernameNotFoundException))
                .andDo(print());

    }

    @Test
    @DisplayName("Must throw an error by update by role not found and return status bad request")
    void mustThrowErrorByUpdateByRoleNotFound() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        UserEntity user = userStub.buildUserEntity();
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        UserUpdateDTO userUpdateDTO = userStub.buildUserRequestDTOUpdate(List.of("x"));

        String requestBody = objectMapper.writeValueAsString(userUpdateDTO);

        mockMvc.perform(put(WEB_METHOD_TEST.V1_USER
                        .concat(SLASH)
                        .concat(EMAIL_PARAM)
                        .concat(user.getEmail()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof RoleEmptyException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw an error by invalid current password and return status bad request")
    void mustThrowErrorByUpdateByInvalidCurrentPassword() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        UserEntity user = userStub.buildUserEntity();
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        UserUpdateDTO userUpdateDTO = userStub.buildUserRequestDTOUpdate(List.of(role.getId()));
        userUpdateDTO.setCurrentPassword("x");

        String requestBody = objectMapper.writeValueAsString(userUpdateDTO);

        mockMvc.perform(put(WEB_METHOD_TEST.V1_USER
                        .concat(SLASH)
                        .concat(EMAIL_PARAM)
                        .concat(user.getEmail()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof InvalidPasswordException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must delete user with success and return status no cotent")
    void mustDeleteUserWithSuccess() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        UserEntity user = userStub.buildUserEntity();
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        String requestBody = objectMapper.writeValueAsString(new PasswordDTO(PASSWORD));

        mockMvc.perform(delete(WEB_METHOD_TEST.V1_USER
                        .concat(SLASH)
                        .concat(EMAIL_PARAM)
                        .concat(user.getEmail()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw an error to delete with user not found and return status bad request")
    void mustThrowErrorToDeleteWithUserNotFound() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        UserEntity user = userStub.buildUserEntity();
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        String requestBody = objectMapper.writeValueAsString(new PasswordDTO(PASSWORD));

        mockMvc.perform(delete(WEB_METHOD_TEST.V1_USER
                        .concat(SLASH)
                        .concat(EMAIL_PARAM)
                        .concat("x"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof UsernameNotFoundException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw an error to delete with invalid current password and return status bad request")
    void mustThrowErrorToDeleteWithInvalidCurrentPassword() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        UserEntity user = userStub.buildUserEntity();
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        String requestBody = objectMapper.writeValueAsString(new PasswordDTO("x"));

        mockMvc.perform(delete(WEB_METHOD_TEST.V1_USER
                        .concat(SLASH)
                        .concat(EMAIL_PARAM)
                        .concat(user.getEmail()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof InvalidPasswordException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must find list user with success and return status ok")
    void mustFindListUserWithSuccess() throws Exception {
        RoleEntity role = roleRepository.save(roleStub.buildRoleEntity());
        UserEntity user = userStub.buildUserEntity();
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);


        mockMvc.perform(get(WEB_METHOD_TEST.V1_USER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value(EMAIL))
                .andDo(print());
    }

    @Test
    @DisplayName("Must thrown an error by find user list is empty and return status bad request")
    void mustThrowErrorByFindUserListIsEmpty() throws Exception {
        userRepository.deleteAll();

        mockMvc.perform(get(WEB_METHOD_TEST.V1_USER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof UserListIsEmpty))
                .andDo(print());
    }
}
