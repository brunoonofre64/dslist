package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.GameDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import io.github.brunoonofre64.dslist.infrastructure.jpa.projections.GameMinProjection;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        GameEntity entity = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game nao encontrado."));

        return new GameDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAllByList(Long listId) {
        List<GameMinProjection> listGames = gameRepository.searchByList(listId);

        if (CollectionUtils.isEmpty(listGames)) {
            throw new RuntimeException("Lista Vazia");
        }

        return listGames
                .stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }
}
