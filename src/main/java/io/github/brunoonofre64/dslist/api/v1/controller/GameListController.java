package io.github.brunoonofre64.dslist.api.v1.controller;

import io.github.brunoonofre64.dslist.domain.dto.GameListDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
import io.github.brunoonofre64.dslist.infrastructure.service.GameListService;
import io.github.brunoonofre64.dslist.infrastructure.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
@RequiredArgsConstructor
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findAllByList(@PathVariable(name = "listId") Long listId) {
        return gameService.findAllByList(listId);
    }
}
