package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.GameDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.domain.exceptions.GameNotFoundException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.projections.GameMinProjection;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameRepository;
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
import static org.mockito.Mockito.when;

@SpringBootTest
class GameServiceTest {

    @InjectMocks
    private GameService service;
    @Mock
    private GameRepository gameRepository;

    private GameEntity gameEntity;
    private GameMinProjection gameMinProjection;

    GameStub gameStub = new GameStub();

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        service = new GameService(gameRepository);
        this.buildArrangeOfTests();
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
    }
}
