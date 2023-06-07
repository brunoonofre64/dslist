package io.brunoonofre64.stubs;

import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;
import io.github.brunoonofre64.dslist.domain.entities.UserEntity;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.EMAIL;
import static io.brunoonofre64.utils.ConstantesIntegrationTest.PASSWORD;

public class UserStubIntegration {

    public UserEntity buildUserEntity() {
        return UserEntity
                .builder()
                .email(EMAIL)
                .password(PASSWORD)
                .build();
    }
}
