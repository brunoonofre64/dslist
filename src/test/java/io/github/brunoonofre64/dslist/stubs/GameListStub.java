package io.github.brunoonofre64.dslist.stubs;

import io.github.brunoonofre64.dslist.domain.dto.GameListDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;

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

    public GameListDTO buildGameListDTO() {
        return GameListDTO
                .builder()
                .id(ID_DEFAULT)
                .name(TEXT_DEFAULT)
                .build();
    }


}
