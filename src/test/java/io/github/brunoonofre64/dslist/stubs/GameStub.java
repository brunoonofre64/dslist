package io.github.brunoonofre64.dslist.stubs;

import io.github.brunoonofre64.dslist.domain.dto.GameMinDTO;
import io.github.brunoonofre64.dslist.domain.dto.GameRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import io.github.brunoonofre64.dslist.infrastructure.jpa.projections.GameMinProjection;

import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.*;

public class GameStub {

    public GameEntity buildGameEntity() {
        return GameEntity
                .builder()
                .id(ID_DEFAULT)
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

    public GameMinDTO buildGameMinDTO() {
        return GameMinDTO
                .builder()
                .id(ID_DEFAULT)
                .title(TEXT_DEFAULT)
                .year(INTEGER_DEFAULT)
                .imgUrl(TEXT_DEFAULT)
                .shortDescription(TEXT_DEFAULT)
                .build();
    }

    public GameRequestDTO buildGameRequestDTO() {
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
                .build();
    }

    public GameMinProjection buildGameMinProjection() {
        return new GameMinProjection() {
            @Override
            public String getId() {
                return ID_DEFAULT;
            }

            @Override
            public String getTitle() {
                return TEXT_DEFAULT;
            }

            @Override
            public Integer getYear() {
                return INTEGER_DEFAULT;
            }

            @Override
            public String getImgUrl() {
                return TEXT_DEFAULT;
            }

            @Override
            public String getShortDescription() {
                return TEXT_DEFAULT;
            }
        };
    }

}
