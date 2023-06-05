package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.GameDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.BelongingEntity;
import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.domain.exceptions.GameNotFoundException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.projections.GameMinProjection;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.BelongingRepository;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameListRepository;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameRepository;
import io.github.brunoonofre64.dslist.stubs.BelongingStub;
import io.github.brunoonofre64.dslist.stubs.GameListStub;
import io.github.brunoonofre64.dslist.stubs.GameStub;
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
import static org.mockito.Mockito.*;

@SpringBootTest
class GameServiceTest {

    @InjectMocks
    private GameService service;
    @Mock
    private GameRepository gameRepository;
    @Mock
    private BelongingRepository belongingRepository;
    @Mock
    private GameListRepository gameListRepository;

    private GameEntity gameEntity;
    private GameMinProjection gameMinProjection;
    private GameRequestDTO gameRequestDTO;
    private GameRequestDTO gameRequestDTOUpdate;
    private GameListEntity gameListEntity;
    private BelongingEntity belongingEntity;

    GameStub gameStub = new GameStub();
    GameListStub gameListStub = new GameListStub();
    BelongingStub belongingStub = new BelongingStub();

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        service = new GameService(gameRepository, belongingRepository, gameListRepository);
        this.buildArrangeOfTests();
    }

    @Test
    @DisplayName("Must save new game with success")
    void mustSaveNewGameWitchSuccess() {
        when(gameListRepository.findById(anyString())).thenReturn(Optional.ofNullable(gameListEntity));
        when(gameRepository.save(any())).thenReturn(gameEntity);
        when(belongingRepository.save(any())).thenReturn(belongingEntity);

        GameDTO response = service.save(gameRequestDTO);

        assertNotNull(response);
        assertEquals(TEXT_DEFAULT, response.getTitle());
        assertEquals(TEXT_DEFAULT, response.getGenre());
    }

    @Test
    @DisplayName("Must throw an error by game input null")
    void mustthrowErrorByGameInputNull() {
        Throwable ex = assertThrows(GameNotFoundException.class,
                () -> service.save(null));

        assertEquals(GameNotFoundException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must update game with success")
    void mustUpdateGameWithSuccess() {
        when(gameRepository.findById(anyString())).thenReturn(Optional.ofNullable(gameEntity));

        GameDTO response = service.update(ID_DEFAULT, gameRequestDTOUpdate);

        assertNotNull(response);
        assertEquals(TEXT_DEFAULT_2, response.getTitle());
        assertEquals(TEXT_DEFAULT_2, response.getGenre());
    }

    @Test
    @DisplayName("Must throw an error to try update with input dto null")
    void mustThrowErrorToTryUpdateWithInputNull() {
        Throwable ex = assertThrows(GameNotFoundException.class,
                () -> service.update(ID_DEFAULT,null));

        assertEquals(GameNotFoundException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must throw an error to try update with input dto null")
    void mustThrowAnErrorToTryUpdateByInvalidId() {
        Throwable ex = assertThrows(GameNotFoundException.class,
                () -> service.update(INVALID_ID, gameRequestDTOUpdate));

        assertEquals(GameNotFoundException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must delete game by id with Success")
    void mustDeleteGameByIdWithSuccesss() {
        doNothing().when(gameRepository).deleteById(ID_DEFAULT);

        gameRepository.deleteById(ID_DEFAULT);

        verify(gameRepository).deleteById(ID_DEFAULT);
        verify(gameRepository, times(1)).deleteById(ID_DEFAULT);
        verify(gameRepository, atLeastOnce()).deleteById(ID_DEFAULT);
    }

    @Test
    @DisplayName("Must throw an error to try delete with invalid id")
    void mustThrowAnErrorToTryDeleteByInvalidId() {
        doThrow(GameNotFoundException.class).when(gameRepository).deleteById(INVALID_ID);

        Throwable ex = assertThrows(GameNotFoundException.class,
                () -> service.delete(INVALID_ID));

        assertEquals(GameNotFoundException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must find all games with success")
    void mustFindAllGamesWithSuccess() {
        when(gameRepository.findAll()).thenReturn(List.of(gameEntity));

        List<GameMinDTO> response = service.findAll();

        assertNotNull(response);
        assertEquals(ID_DEFAULT, response.get(INDEX_ZERO).getId());
        assertEquals(TEXT_DEFAULT, response.get(INDEX_ZERO).getTitle());
    }

    @Test
    @DisplayName("Must throw an error by call empty game list")
    void mustThrowErrorByFindEmptyGameList() {
        Throwable ex = assertThrows(EmptyListException.class,
                () -> service.findAll());

        assertEquals(EmptyListException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must find game by id with success")
    void mustFindGameByIdWithSuccess() {
        when(gameRepository.findById(anyString())).thenReturn(Optional.ofNullable(gameEntity));

        GameDTO response = service.findById(ID_DEFAULT);

        assertNotNull(response);
        assertEquals(TEXT_DEFAULT, response.getTitle());
        assertEquals(DOUBLE_DEFAULT, response.getScore());
    }

    @Test
    @DisplayName("Must throw an error by game not found")
    void mustThrowErrorByGameNotFound() {
        Throwable ex = assertThrows(GameNotFoundException.class,
                () -> service.findById(ID_DEFAULT));

        assertEquals(GameNotFoundException.class, ex.getClass());
    }

    @Test
    @DisplayName("Must find all games by list with success")
    void mustFindAllGamesByListWithSuccess() {
        when(gameRepository.searchByList(anyString())).thenReturn(List.of(gameMinProjection));

        List<GameMinDTO> response = service.findAllByListId(ID_DEFAULT);

        assertNotNull(response);
        assertEquals(ID_DEFAULT, response.get(INDEX_ZERO).getId());
        assertEquals(TEXT_DEFAULT, response.get(INDEX_ZERO).getTitle());
    }

    @Test
    @DisplayName("Must throw an error by game empty list")
    void mustThrowErrorByGameEmptyList() {
        Throwable ex = assertThrows(EmptyListException.class,
                () -> service.findAllByListId(ID_DEFAULT));

        assertEquals(EmptyListException.class, ex.getClass());
    }

    private void buildArrangeOfTests() {
        gameEntity = gameStub.buildGameEntity();
        gameMinProjection = gameStub.buildGameMinProjection();
        gameRequestDTO = gameStub.buildGameRequestDTO();
        gameRequestDTOUpdate = gameStub.buildGameRequestDTOUpdate();
        gameListEntity = gameListStub.buildGameListEntity();
        belongingEntity = belongingStub.buildBelongingEntity();
    }
}
