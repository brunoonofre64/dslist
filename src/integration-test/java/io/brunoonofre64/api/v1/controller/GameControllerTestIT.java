package io.brunoonofre64.api.v1.controller;

import io.brunoonofre64.stubs.GameStubIntegration;
import io.brunoonofre64.utils.ConstantesIntegrationTest.WEB_METHOD_TEST;
import io.github.brunoonofre64.dslist.DslistApplication;
import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.TEXT_DEFAULT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DslistApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("TEST-H2")
@AutoConfigureMockMvc
class GameControllerTestIT {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void seUp() {
        gameRepository.deleteAll();

    }

    GameStubIntegration gameStub = new GameStubIntegration();

    @Test
    @DisplayName("Must find all games with success and return status ok")
    void mustFindAllGamesWithSuccessAndReturnOk() throws Exception {
        gameRepository.save(gameStub.buildGameEntity());

        mockMvc.perform(get(WEB_METHOD_TEST.V1_GAME)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title").value(TEXT_DEFAULT))
                .andDo(print());
    }
}
