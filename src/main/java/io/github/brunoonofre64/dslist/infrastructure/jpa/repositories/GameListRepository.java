package io.github.brunoonofre64.dslist.infrastructure.jpa.repositories;

import io.github.brunoonofre64.dslist.domain.entities.GameListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameListEntity, String> {
}
