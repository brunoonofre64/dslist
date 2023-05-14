package io.github.brunoonofre64.dslist.api.v1.controller;

import io.github.brunoonofre64.dslist.domain.dto.GameDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<GameMinDTO> findAll() {
        return gameService.findAll();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.findById(id);
    }
}
