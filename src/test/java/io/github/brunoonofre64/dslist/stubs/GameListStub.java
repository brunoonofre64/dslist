package io.github.brunoonofre64.dslist.stubs;

import io.github.brunoonofre64.dslist.domain.dto.GameListRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.TEXT_DEFAULT_2;
import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.ID_DEFAULT;
import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.TEXT_DEFAULT;

public class GameListStub {

    public GameListEntity buildGameListEntity() {
        return GameListEntity
                .builder()
                .id(ID_DEFAULT)
                .name(TEXT_DEFAULT)
                .build();
    }

    public GameListRequestDTO buildGameListRequestDTO() {
        return GameListRequestDTO
                .builder()
                .name(TEXT_DEFAULT)
                .build();
    }

    public GameListRequestDTO buildGameListRequestDTOUpdate() {
        return GameListRequestDTO
                .builder()
                .name(TEXT_DEFAULT_2)
                .build();
    }
}
