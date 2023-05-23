package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.GameListDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameListRepository;
import io.github.brunoonofre64.dslist.stubs.GameListStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GameListServiceTest {

    @InjectMocks
    private GameListService gameListService;
    @Mock
    private GameListRepository gameListRepository;

    private GameListEntity gameListEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameListService = new GameListService(gameListRepository);
        this.buildArrangeOfTests();
    }

    GameListStub gameListStub = new GameListStub();

    @Test
    @DisplayName("Must find all game lists with success")
    void mustFindAllGameListsWithSuccess() {
        when(gameListRepository.findAll()).thenReturn(List.of(gameListEntity));

        List<GameListDTO> response = gameListService.findAll();

        assertNotNull(response);
        assertEquals(ID_DEFAULT, response.get(INDEX_ZERO).getId());
        assertEquals(TEXT_DEFAULT, response.get(INDEX_ZERO).getName());
    }

    @Test
    @DisplayName("Must throw error by game list is empty")
    void mustThrowErrorByGameListIsEmpty() {
        Throwable ex = assertThrows(EmptyListException.class,
                () -> gameListService.findAll());

        assertEquals(EmptyListException.class, ex.getClass());
    }

    private void buildArrangeOfTests() {
        gameListEntity = gameListStub.buildGameListEntity();
    }
}
