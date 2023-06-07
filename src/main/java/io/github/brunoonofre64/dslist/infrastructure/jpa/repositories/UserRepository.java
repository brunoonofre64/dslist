package io.github.brunoonofre64.dslist.infrastructure.jpa.repositories;

import io.github.brunoonofre64.dslist.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    void deleteByEmail(String email);
}

