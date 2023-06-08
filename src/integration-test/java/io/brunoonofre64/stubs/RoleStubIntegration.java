package io.brunoonofre64.stubs;

import io.github.brunoonofre64.dslist.domain.dto.RoleRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.ROLE_ADMIN;
import static io.brunoonofre64.utils.ConstantesIntegrationTest.USER;

public class RoleStubIntegration {

    public RoleEntity buildRoleEntity() {
        return RoleEntity
                .builder()
                .roleName(ROLE_ADMIN)
                .build();
    }

    public RoleRequestDTO buildRoleRequestDTO() {
        return RoleRequestDTO
                .builder()
                .roleName(USER)
                .build();
    }
}
