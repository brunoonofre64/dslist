package io.brunoonofre64.stubs;

import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.TEXT_DEFAULT;

public class GameListStubIntegration {

    public GameListEntity buildGameListEntity() {
        return GameListEntity
                .builder()
                .name(TEXT_DEFAULT)
                .build();
    }
}
