package io.github.brunoonofre64.dslist.stubs;

import io.github.brunoonofre64.dslist.domain.dto.RoleRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;

import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.ID_DEFAULT;
import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.TEXT_DEFAULT;

public class RoleStub {

    public RoleEntity buildRoleEntity() {
        return RoleEntity
                .builder()
                .id(ID_DEFAULT)
                .roleName(TEXT_DEFAULT)
                .build();
    }

    public RoleRequestDTO buildRoleRequestDTO() {
        return RoleRequestDTO
                .builder()
                .roleName(TEXT_DEFAULT)
                .build();
    }
}
