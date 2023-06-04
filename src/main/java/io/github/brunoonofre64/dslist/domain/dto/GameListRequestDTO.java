package io.github.brunoonofre64.dslist.domain.dto;

import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameListRequestDTO {
    private String name;

    public GameListEntity toEntity() {
        GameListEntity entity = new GameListEntity();

        BeanUtils.copyProperties(this, entity);

        return entity;
    }

    public void toEntity(GameListEntity entity) {
        BeanUtils.copyProperties(this, entity);
    }
}
