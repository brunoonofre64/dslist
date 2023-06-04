package io.github.brunoonofre64.dslist.stubs;

import io.github.brunoonofre64.dslist.domain.entities.BelongingEntity;
import io.github.brunoonofre64.dslist.domain.entities.BelongingPK;

public class BelongingStub {

    GameStub gameStub = new GameStub();
    GameListStub gameListStub = new GameListStub();

    public BelongingEntity buildBelongingEntity() {
        return BelongingEntity
                .builder()
                .belongingPK(this.buildBelongingPK())
                .position(1)
                .build();
    }

    public BelongingPK buildBelongingPK() {
        return BelongingPK
                .builder()
                .game(gameStub.buildGameEntity())
                .gameList(gameListStub.buildGameListEntity())
                .build();
    }
}
