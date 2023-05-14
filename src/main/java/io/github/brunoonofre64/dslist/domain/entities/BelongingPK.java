package io.github.brunoonofre64.dslist.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BelongingPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameListEntity gameList;
}
