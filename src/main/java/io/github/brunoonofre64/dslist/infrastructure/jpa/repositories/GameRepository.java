package io.github.brunoonofre64.dslist.infrastructure.jpa.repositories;

import io.github.brunoonofre64.dslist.domain.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
}
