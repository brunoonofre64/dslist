package io.brunoonofre64.api.v1.controller;

import io.brunoonofre64.utils.ConstantesIntegrationTest;
import io.github.brunoonofre64.dslist.DslistApplication;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameListRepository;
import io.github.brunoonofre64.dslist.stubs.GameListStub;
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
import static io.brunoonofre64.utils.ConstantesIntegrationTest.WEB_METHOD_TEST;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    GameListStub gameListStub = new GameListStub();

    @Test
    @DisplayName("Must find all game lists with success and return status ok ")
    void mustFindAllGameListsWithSuccess() throws Exception {
        gameListRepository.save(gameListStub.buildGameListEntity());

        mockMvc.perform(get(ConstantesIntegrationTest.WEB_METHOD_TEST.V1_LIST)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value(TEXT_DEFAULT))
                .andDo(print());
    }

    @Test
    @DisplayName("should throw error for no game list found and return status bad request")
    void mustThrowErrorByGameListdNotFound() throws Exception {

        mockMvc.perform(get(WEB_METHOD_TEST.V1_LIST)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof EmptyListException))
                .andDo(print());
    }
}
