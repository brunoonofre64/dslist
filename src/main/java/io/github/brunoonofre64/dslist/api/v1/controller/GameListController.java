package io.github.brunoonofre64.dslist.api.v1.controller;

import io.github.brunoonofre64.dslist.domain.dto.GameListDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameListRequestDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
import io.github.brunoonofre64.dslist.infrastructure.service.GameListService;
import io.github.brunoonofre64.dslist.infrastructure.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GameListDTO save(@RequestBody GameListRequestDTO gameListRequestDTO) {
        return gameListService.save(gameListRequestDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public GameListDTO update(@PathVariable String id, @RequestBody GameListRequestDTO gameListRequestDTO) {
        return gameListService.update(id, gameListRequestDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        gameListService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findAllByList(@PathVariable(name = "listId") String listId) {
        return gameService.findAllByListId(listId);
    }
}
