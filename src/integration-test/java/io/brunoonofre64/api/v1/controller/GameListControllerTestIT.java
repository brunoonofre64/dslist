package io.brunoonofre64.api.v1.controller;

import io.brunoonofre64.stubs.GameListStubIntegration;
import io.github.brunoonofre64.dslist.DslistApplication;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = DslistApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("TEST-H2")
@AutoConfigureMockMvc
class GameListControllerTestIT {

    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void seUp() {
        gameListRepository.deleteAll();
    }

    GameListStubIntegration gameListStub = new GameListStubIntegration();

}
