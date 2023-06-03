package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.GameListDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameListRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.domain.exceptions.GameListNotFoundException;
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
import java.util.Optional;

import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class GameListServiceTest {

    @InjectMocks
    private GameListService gameListService;
    @Mock
    private GameListRepository gameListRepository;

    private GameListEntity gameListEntity;
    private GameListRequestDTO gameListRequestDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameListService = new GameListService(gameListRepository);
        this.buildArrangeOfTests();
    }

    GameListStub gameListStub = new GameListStub();

    @Test
    @DisplayName("Must save new game list with success")
    void mustSaveNewGameListWithSuccess() {
        when(gameListRepository.save(any())).thenReturn(gameListEntity);

        GameListDTO response = gameListService.save(gameListRequestDTO);

        assertNotNull(response);
        assertEquals(TEXT_DEFAULT, response.getName());
        assertEquals(ID_DEFAULT, response.getId());
    }

    @Test
    @DisplayName("Must throw an error by request input null")
    void mustThrowErrorByInputNull() {
        Throwable ex = assertThrows(GameListNotFoundException.class,
                () -> gameListService.save(null));

        assertEquals(GameListNotFoundException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must update game list with success")
    void mustUpdateGameListWithSuccess() {
        when(gameListRepository.findById(anyString())).thenReturn(Optional.ofNullable(gameListEntity));
        when(gameListRepository.save(any())).thenReturn(gameListEntity);

        GameListDTO response = gameListService.update(ID_DEFAULT, gameListRequestDTO);

        assertNotNull(response);
        assertEquals(TEXT_DEFAULT, response.getName());
        assertEquals(ID_DEFAULT, response.getId());
    }

    @Test
    @DisplayName("Must throw an error when try update with input null")
    void mustThrowErrorWhenTryUpdateWithInputNull() {
        Throwable ex = assertThrows(GameListNotFoundException.class,
                () -> gameListService.update(ID_DEFAULT, null));

        assertEquals(GameListNotFoundException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must throw an error when try update with invalid id")
    void mustThrowErrorWhenTryUpdateWithIvalidId() {
        Throwable ex = assertThrows(GameListNotFoundException.class,
                () -> gameListService.update(INVALID_ID, gameListRequestDTO));

        assertEquals(GameListNotFoundException.class, ex.getClass());
    }

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
        gameListRequestDTO = gameListStub.buildGameListRequestDTO();
    }
}
