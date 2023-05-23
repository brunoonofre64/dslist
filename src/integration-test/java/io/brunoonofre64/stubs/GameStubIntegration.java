package io.brunoonofre64.stubs;

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

}
