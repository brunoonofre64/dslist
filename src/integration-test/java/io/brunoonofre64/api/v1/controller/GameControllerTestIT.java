package io.brunoonofre64.api.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.brunoonofre64.stubs.GameListStubIntegration;
import io.brunoonofre64.stubs.GameStubIntegration;
import io.brunoonofre64.utils.ConstantesIntegrationTest;
import io.github.brunoonofre64.dslist.DslistApplication;
import io.github.brunoonofre64.dslist.domain.entities.BelongingEntity;
import io.github.brunoonofre64.dslist.domain.entities.BelongingPK;
import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.domain.exceptions.GameNotFoundException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.BelongingRepository;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameListRepository;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameRepository;
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
import org.springframework.transaction.annotation.Transactional;

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
class GameControllerTestIT extends IntegrationTestBase {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private BelongingRepository belongingRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void seUp() {
        gameRepository.deleteAll();
        super.buildUserWithAuthorities();
    }

    GameStubIntegration gameStub = new GameStubIntegration();
    GameListStubIntegration gameListStub = new GameListStubIntegration();

    @Test
    @DisplayName("Must save game with success and return status created")
    void mustSaveGameWithSuccess() throws Exception {
        GameListEntity gameList = gameListRepository.save(gameListStub.buildGameListEntity());
        String requestBody = objectMapper.writeValueAsString(gameStub.buildGameRequestDTO(gameList.getId()));

        mockMvc.perform(post(WEB_METHOD_TEST.V1_GAME)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value(TEXT_DEFAULT))
                .andDo(print());

    }

    @Test
    @DisplayName("Must throw an error when try save with request null and return status bad request")
    void mustThrowErrorWhenTrySaveWithRequestNull() throws Exception {

        mockMvc.perform(post(WEB_METHOD_TEST.V1_GAME)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(""))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof HttpMessageNotReadableException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must update game with success and return status no content")
    void mustUpdateGameWithSuccess() throws Exception {
        GameEntity game = gameRepository.save(gameStub.buildGameEntity());
        String expectedId = game.getId();

        String requestBody = objectMapper.writeValueAsString(gameStub.buildGameRequestDTOUpdate());

        mockMvc.perform(put(WEB_METHOD_TEST.V1_GAME
                        .concat(SLASH)
                        .concat(expectedId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.title").value(TEXT_DEFAULT_2))
                .andDo(print());

    }

    @Test
    @DisplayName("Must throw an error when try update with request null and return status bad request")
    void mustThrowErrorWhenTryUpdateWithRequestNull() throws Exception {
        GameEntity game = gameRepository.save(gameStub.buildGameEntity());
        String expectedId = game.getId();

        mockMvc.perform(put(WEB_METHOD_TEST.V1_GAME
                        .concat(SLASH)
                        .concat(expectedId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(""))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof HttpMessageNotReadableException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw an error when try update with invalid id and return status bad request")
    void mustThrowErrorWhenTryUpdateWithInvalidId() throws Exception {
        GameListEntity gameList = gameListRepository.save(gameListStub.buildGameListEntity());
        String requestBody = objectMapper.writeValueAsString(gameStub.buildGameRequestDTO(gameList.getId()));


        mockMvc.perform(put(WEB_METHOD_TEST.V1_GAME
                        .concat(SLASH)
                        .concat(INVALID_ID))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader())
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof GameNotFoundException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must delete game with success and return status no content")
    void mustDeleteGameByIdWithSuccess() throws Exception {
        GameEntity game = gameRepository.save(gameStub.buildGameEntity());
        String expectedId = game.getId();

        mockMvc.perform(delete(WEB_METHOD_TEST.V1_GAME
                        .concat(SLASH)
                        .concat(expectedId))
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isNoContent())
                .andDo(print());

    }

    @Test
    @DisplayName("Must throw an error when try delete with invalid id and return status bad request")
    void mustThrowErrorWhenTryDeleteWithInvalidId() throws Exception {
        mockMvc.perform(delete(WEB_METHOD_TEST.V1_GAME
                        .concat(SLASH)
                        .concat(INVALID_ID))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof GameNotFoundException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must find all games with success and return status ok")
    void mustFindAllGamesWithSuccessAndReturnOk() throws Exception {
        gameRepository.save(gameStub.buildGameEntity());

        mockMvc.perform(get(WEB_METHOD_TEST.V1_GAME)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title").value(TEXT_DEFAULT))
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw error by empty game list and return status bad request")
    void mustThrowErrorByEmptyGameList() throws Exception {

        mockMvc.perform(get(WEB_METHOD_TEST.V1_GAME)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof EmptyListException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must find game by id with succees and return status ok")
    void mustFindGameByIdWithSuccess() throws Exception {
        GameEntity game = gameRepository.save(gameStub.buildGameEntity());
        String expectedId = game.getId();

        mockMvc.perform(get(WEB_METHOD_TEST.V1_GAME.concat(SLASH).concat(expectedId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(TEXT_DEFAULT))
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw error by game not found return status bad request")
    void mustThrowErrorByGameNotFound() throws Exception {

        mockMvc.perform(get(WEB_METHOD_TEST.V1_GAME.concat(SLASH).concat(NONEXISTENT_ID))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof GameNotFoundException))
                .andDo(print());
    }

    @Test
    @DisplayName("Must find all list games by list id and return status ok")
    void mustFindAllListGamesByListId() throws Exception {
        GameEntity game = gameRepository.save(gameStub.buildGameEntity());
        GameListEntity gameList = gameListRepository.save(gameListStub.buildGameListEntity());

        BelongingPK belongingPK = new BelongingPK(game, gameList);
        BelongingEntity belonging = new BelongingEntity(belongingPK, 1);
        belongingRepository.save(belonging);

        String expectedId = gameList.getId();

        mockMvc.perform(get(ConstantesIntegrationTest.WEB_METHOD_TEST.V1_LIST
                        .concat(SLASH)
                        .concat(expectedId)
                        .concat(SLASH)
                        .concat(GAMES))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title").value(TEXT_DEFAULT))
                .andDo(print());
    }

    @Test
    @DisplayName("Must throw error by empty game list and return status bad request")
    void mustThrowErrorByListIdNotFound() throws Exception {

        mockMvc.perform(get(WEB_METHOD_TEST.V1_LIST
                        .concat(SLASH)
                        .concat(NONEXISTENT_ID)
                        .concat(SLASH)
                        .concat(GAMES))
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(getAuthorizationHeader()))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof EmptyListException))
                .andDo(print());
    }
}
