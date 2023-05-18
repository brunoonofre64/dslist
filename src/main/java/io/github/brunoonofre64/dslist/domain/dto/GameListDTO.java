package io.github.brunoonofre64.dslist.domain.dto;

import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameListDTO {
    private String id;

    private String name;

    public GameListDTO(GameListEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
