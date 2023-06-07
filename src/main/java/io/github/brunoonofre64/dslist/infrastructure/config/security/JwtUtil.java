package io.github.brunoonofre64.dslist.infrastructure.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;
import io.github.brunoonofre64.dslist.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UserEntity userEntity) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(userEntity.getEmail())
                .withClaim("roles", userEntity.getRoles().stream()
                        .map(RoleEntity::getRoleName).collect(Collectors.toList()))
                .sign(algorithm);
    }
}

