package io.github.brunoonofre64.dslist.domain.dto;

import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameRequestDTO {

    private String title;
    private Double score;
    private Integer year;
    private String genre;
    private String platforms;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;
    private String gameListId;
    private int gamePosition;


    public GameEntity toEntity() {
        GameEntity entity = new GameEntity();

        BeanUtils.copyProperties(this, entity);

        return entity;
    }

    public void toEntity(GameEntity entity) {
        BeanUtils.copyProperties(this, entity);
    }
}
