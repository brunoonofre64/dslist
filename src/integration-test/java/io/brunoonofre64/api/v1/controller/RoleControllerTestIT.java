package io.brunoonofre64.api.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.brunoonofre64.stubs.RoleStubIntegration;
import io.brunoonofre64.utils.ConstantesIntegrationTest.WEB_METHOD_TEST;
import io.github.brunoonofre64.dslist.DslistApplication;
import io.github.brunoonofre64.dslist.domain.dto.RoleRequestDTO;
import io.github.brunoonofre64.dslist.domain.exceptions.RoleAlreadyExistsException;
import io.github.brunoonofre64.dslist.domain.exceptions.RoleEmptyException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.ADMIN;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest(classes = DslistApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("TEST-H2")
@AutoConfigureMockMvc
class RoleControllerTestIT extends IntegrationTestBase {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        roleRepository.deleteAll();
        super.buildUserWithAuthorities();
    }

    RoleStubIntegration roleStub = new RoleStubIntegration();

    @Test
    @DisplayName("Must save role with success and return status created")
    void mustSaveRoleWithSuccess() throws Exception {
        String requestBody = objectMapper.writeValueAsString(roleStub.buildRoleRequestDTO());

        mockMvc.perform(post(WEB_METHOD_TEST.V1_ROLE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    @DisplayName("Must thrown an error by role is null and return status bad request")
    void mustThrowErrorByRoleNull() throws Exception {
       RoleRequestDTO roleRequestDTO =  roleStub.buildRoleRequestDTO();
       roleRequestDTO.setRoleName(null);
        String requestBody = objectMapper.writeValueAsString(roleRequestDTO);

        mockMvc.perform(post(WEB_METHOD_TEST.V1_ROLE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof RoleEmptyException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must thrown an error by role already exists and return status bad request")
    void mustThrowErrorByRoleAlradyExists() throws Exception {
        RoleRequestDTO roleRequestDTO =  roleStub.buildRoleRequestDTO();
        roleRequestDTO.setRoleName(ADMIN);
        String requestBody = objectMapper.writeValueAsString(roleRequestDTO);

        mockMvc.perform(post(WEB_METHOD_TEST.V1_ROLE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof RoleAlreadyExistsException))
                .andDo(print());
    }
}
