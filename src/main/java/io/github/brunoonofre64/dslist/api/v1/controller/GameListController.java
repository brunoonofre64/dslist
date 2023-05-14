package io.github.brunoonofre64.dslist.api.v1.controller;

import io.github.brunoonofre64.dslist.domain.dto.GameListDTO;
import io.github.brunoonofre64.dslist.infrastructure.service.GameListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
@RequiredArgsConstructor
public class GameListController {

    private final GameListService gameListService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
}
