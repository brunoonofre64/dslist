package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.GameDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.BelongingEntity;
import io.github.brunoonofre64.dslist.domain.entities.BelongingPK;
import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import io.github.brunoonofre64.dslist.domain.enums.CodeMessage;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.domain.exceptions.GameListNotFoundException;
import io.github.brunoonofre64.dslist.domain.exceptions.GameNotFoundException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.projections.GameMinProjection;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.BelongingRepository;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameListRepository;
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
    private final BelongingRepository belongingRepository;
    private final GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<GameEntity> listGames = gameRepository.findAll();

        if (CollectionUtils.isEmpty(listGames)) {
            throw new EmptyListException(CodeMessage.EMPTY_LIST);
        }

        return listGames
                .stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameDTO findById(String id) {
        GameEntity entity = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(CodeMessage.GAME_NOT_FOUND));

        return new GameDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAllByListId(String listId) {
        List<GameMinProjection> listGames = gameRepository.searchByList(listId);

        if (CollectionUtils.isEmpty(listGames)) {
            throw new EmptyListException(CodeMessage.EMPTY_LIST);
        }

        return listGames
                .stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public GameDTO save(GameRequestDTO gameRequestDTO) {
        if (gameRequestDTO == null) {
            throw new GameNotFoundException(CodeMessage.GAME_NOT_FOUND);
        }

        GameEntity entity = gameRequestDTO.toEntity();

        GameListEntity listEntity = gameListRepository.findById(gameRequestDTO.getGameListId())
                .orElseThrow(() -> new GameListNotFoundException(CodeMessage.GAME_LIST_NOT_FOUND));

        BelongingPK belongingPK = new BelongingPK(entity, listEntity);
        BelongingEntity belonging = new BelongingEntity(belongingPK, gameRequestDTO.getGamePosition());

        gameRepository.save(entity);
        belongingRepository.save(belonging);

        return new GameDTO(entity);
    }

    public GameDTO update(String id, GameRequestDTO gameRequestDTO) {
        if (gameRequestDTO == null) {
            throw new GameNotFoundException(CodeMessage.GAME_NOT_FOUND);
        }

        GameEntity entity = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(CodeMessage.GAME_NOT_FOUND));

        gameRequestDTO.toEntity(entity);

        gameRepository.save(entity);

        return new GameDTO(entity);
    }

    @Transactional
    public void delete(String id) {
        try {
            gameRepository.deleteById(id);
        } catch (Exception ex) {
            throw new GameNotFoundException(CodeMessage.GAME_NOT_FOUND);
        }
    }
}
