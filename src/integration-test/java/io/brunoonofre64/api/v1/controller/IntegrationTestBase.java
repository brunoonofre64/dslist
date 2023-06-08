package io.brunoonofre64.api.v1.controller;

import io.github.brunoonofre64.dslist.DslistApplication;
import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;
import io.github.brunoonofre64.dslist.domain.entities.UserEntity;
import io.github.brunoonofre64.dslist.infrastructure.config.security.JwtUtil;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.RoleRepository;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.*;

@SpringBootTest(classes = DslistApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("TEST-H2")
@AutoConfigureMockMvc
public class IntegrationTestBase {

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected RoleRepository roleRepository;
    @Autowired
    protected PasswordEncoder passwordEncoder;
    @Autowired
    protected JwtUtil jwtUtil;

    protected String jwtToken;

    protected void buildUserWithAuthorities() {
        RoleEntity role = RoleEntity
                .builder()
                .roleName(ROLE_ADMIN)
                .build();

        roleRepository.save(role);

        UserEntity user = UserEntity.builder()
                .email(EMAIL)
                .password(passwordEncoder.encode(PASSWORD))
                .roles(Collections.singletonList(role))
                .build();
        userRepository.save(user);

        jwtToken = jwtUtil.generateToken(user);
    }

    protected HttpHeaders getAuthorizationHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);
        return headers;
    }
}
