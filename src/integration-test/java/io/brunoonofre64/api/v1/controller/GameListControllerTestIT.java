package io.brunoonofre64.api.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.brunoonofre64.dslist.DslistApplication;
import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.domain.exceptions.GameListNotFoundException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameListRepository;
import io.github.brunoonofre64.dslist.stubs.GameListStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void seUp() {
        gameListRepository.deleteAll();
    }

    GameListStub gameListStub = new GameListStub();

    @Test
    @DisplayName("Must save game list with success and return status created ")
    void mustSaveGameListWithSuccess() throws Exception {
        String requestBody = objectMapper.writeValueAsString(gameListStub.buildGameListRequestDTO());

        mockMvc.perform(post(WEB_METHOD_TEST.V1_LIST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(TEXT_DEFAULT))
                .andDo(print());

    }

    @Test
    @DisplayName("Must throw an error by game list input null and return status bad request")
    void mustThrowErrorByGameListInputNull() throws Exception {

        mockMvc.perform(post(WEB_METHOD_TEST.V1_LIST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof HttpMessageNotReadableException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must update game list with success and return status no content")
    void mustUpdateGameListWithSuccess() throws Exception {
        GameListEntity gameList = gameListRepository.save(gameListStub.buildGameListEntity());
        String expectedId = gameList.getId();

        String requestBody = objectMapper.writeValueAsString(gameListStub.buildGameListRequestDTOUpdate());

        mockMvc.perform(put(WEB_METHOD_TEST.V1_LIST
                        .concat(SLASH)
                        .concat(expectedId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.name").value(TEXT_DEFAULT_2))
                .andDo(print());

    }

    @Test
    @DisplayName("Must throw an error when try update with request null and return status bad request")
    void mustThrowErrorWhenTryUpdateWithRequestNull() throws Exception {
        GameListEntity gameList = gameListRepository.save(gameListStub.buildGameListEntity());
        String expectedId = gameList.getId();

        mockMvc.perform(put(WEB_METHOD_TEST.V1_LIST
                        .concat(SLASH)
                        .concat(expectedId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof HttpMessageNotReadableException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw an error when try update with invalid id and return status bad request")
    void mustThrowErrorWhenTryUpdateWithInvalidId() throws Exception {
        gameListRepository.save(gameListStub.buildGameListEntity());
        String requestBody = objectMapper.writeValueAsString(gameListStub.buildGameListRequestDTOUpdate());


        mockMvc.perform(put(WEB_METHOD_TEST.V1_LIST
                        .concat(SLASH)
                        .concat(INVALID_ID))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof GameListNotFoundException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must delete game list with success and return status no content")
    void mustDeleteGameListByIdWithSuccess() throws Exception {
        GameListEntity gameList = gameListRepository.save(gameListStub.buildGameListEntity());
        String expectedId = gameList.getId();

        mockMvc.perform(delete(WEB_METHOD_TEST.V1_LIST
                        .concat(SLASH)
                        .concat(expectedId)))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw an error when try delete with invalid id and return status bad request")
    void mustThrowErrorWhenTryDeleteWithInvalidId() throws Exception {
        mockMvc.perform(delete(WEB_METHOD_TEST.V1_LIST
                        .concat(SLASH)
                        .concat(INVALID_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof GameListNotFoundException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must find all game lists with success and return status ok ")
    void mustFindAllGameListsWithSuccess() throws Exception {
        gameListRepository.save(gameListStub.buildGameListEntity());

        mockMvc.perform(get(WEB_METHOD_TEST.V1_LIST)
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
