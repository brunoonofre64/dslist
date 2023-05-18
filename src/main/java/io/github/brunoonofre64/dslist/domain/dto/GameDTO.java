package io.github.brunoonofre64.dslist.domain.dto;

import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO {

    private String id;
    private String title;
    private Double score;
    private Integer year;
    private String genre;
    private String platforms;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(GameEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
