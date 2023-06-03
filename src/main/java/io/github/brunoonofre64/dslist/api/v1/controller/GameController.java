package io.github.brunoonofre64.dslist.api.v1.controller;

import io.github.brunoonofre64.dslist.domain.dto.GameDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameRequestDTO;
import io.github.brunoonofre64.dslist.infrastructure.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GameDTO save(@RequestBody GameRequestDTO gameRequestDTO) {
        return gameService.save(gameRequestDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public GameDTO update(@PathVariable String id, @RequestBody GameRequestDTO gameRequestDTO) {
        return gameService.update(id, gameRequestDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        gameService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable String id) {
        return gameService.findById(id);
    }
}
