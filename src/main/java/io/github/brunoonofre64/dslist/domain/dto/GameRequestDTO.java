package io.github.brunoonofre64.dslist.domain.dto;

import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Builder
@Getter
@Setter
public class GameRequestDTO {

    private String title;
    private Double score;
    private Integer year;
    private String genre;
    private String platforms;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;


    public GameEntity toEntity() {
        GameEntity entity = new GameEntity();

        BeanUtils.copyProperties(this, entity);

        return entity;
    }
}
