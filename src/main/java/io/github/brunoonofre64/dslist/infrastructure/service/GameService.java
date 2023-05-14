package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

   public List<GameMinDTO> findAll() {
        List<GameEntity> listGames = gameRepository.findAll();

        if (CollectionUtils.isEmpty(listGames)) {
            throw new RuntimeException("Lista Vazia");
        }

        return listGames
                .stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }
}
