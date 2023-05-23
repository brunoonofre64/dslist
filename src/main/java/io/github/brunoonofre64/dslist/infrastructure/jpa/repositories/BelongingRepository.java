package io.github.brunoonofre64.dslist.infrastructure.jpa.repositories;

import io.github.brunoonofre64.dslist.domain.entities.BelongingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BelongingRepository extends JpaRepository<BelongingEntity, String> {
}
