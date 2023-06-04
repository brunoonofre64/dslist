package io.github.brunoonofre64.dslist.domain.entities;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_belonging")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BelongingEntity {

    @EmbeddedId
    private BelongingPK belongingPK;

    private Integer position;

    public BelongingEntity(GameEntity game, GameListEntity gameList, Integer position) {
        belongingPK.setGame(game);
        belongingPK.setGameList(gameList);
        this.position = position;
    }
}
