package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.GameListDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import io.github.brunoonofre64.dslist.domain.enums.CodeMessage;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.GameListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameListService {

    private final GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameListEntity> allLists = gameListRepository.findAll();

        if (CollectionUtils.isEmpty(allLists)) {
            throw new EmptyListException(CodeMessage.EMPTY_LIST);
        }

        return allLists
                .stream()
                .map(GameListDTO::new)
                .collect(Collectors.toList());
    }
}
