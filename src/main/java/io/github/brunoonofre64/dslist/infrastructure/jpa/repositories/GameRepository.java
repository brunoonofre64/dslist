package io.github.brunoonofre64.dslist.infrastructure.jpa.repositories;

import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import io.github.brunoonofre64.dslist.infrastructure.jpa.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {

    @Query("SELECT g FROM GameEntity g JOIN BelongingEntity b " +
            "ON g.id = b.belongingPK.game.id WHERE b.belongingPK.gameList.id = :listId " +
            "ORDER BY b.position")
    List<GameMinProjection> searchByList(Long listId);


}
