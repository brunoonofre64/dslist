package io.brunoonofre64.stubs;

import io.github.brunoonofre64.dslist.domain.dto.GameRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameEntity;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.*;

public class GameStubIntegration {

    public GameEntity buildGameEntity() {
        return GameEntity
                .builder()
                .title(TEXT_DEFAULT)
                .score(DOUBLE_DEFAULT)
                .year(INTEGER_DEFAULT)
                .genre(TEXT_DEFAULT)
                .platforms(TEXT_DEFAULT)
                .imgUrl(TEXT_DEFAULT)
                .shortDescription(TEXT_DEFAULT)
                .longDescription(TEXT_DEFAULT)
                .build();
    }

    public GameRequestDTO buildGameRequestDTO(String gameListId) {
        return GameRequestDTO
                .builder()
                .title(TEXT_DEFAULT)
                .score(DOUBLE_DEFAULT)
                .year(INTEGER_DEFAULT)
                .genre(TEXT_DEFAULT)
                .platforms(TEXT_DEFAULT)
                .imgUrl(TEXT_DEFAULT)
                .shortDescription(TEXT_DEFAULT)
                .longDescription(TEXT_DEFAULT)
                .gameListId(gameListId)
                .gamePosition(1)
                .build();
    }

    public GameRequestDTO buildGameRequestDTOUpdate() {
        return GameRequestDTO
                .builder()
                .title(TEXT_DEFAULT_2)
                .score(DOUBLE_DEFAULT_2)
                .year(INTEGER_DEFAULT_2)
                .genre(TEXT_DEFAULT_2)
                .platforms(TEXT_DEFAULT_2)
                .imgUrl(TEXT_DEFAULT_2)
                .shortDescription(TEXT_DEFAULT_2)
                .longDescription(TEXT_DEFAULT_2)
                .gameListId(ID_DEFAULT)
                .gamePosition(1)
                .build();
    }
}
