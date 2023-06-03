package io.github.brunoonofre64.dslist.domain.dto;

import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@Builder
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
