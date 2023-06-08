package io.github.brunoonofre64.dslist.stubs;

import io.github.brunoonofre64.dslist.domain.dto.PasswordDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserRequestDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserUpdateDTO;
import io.github.brunoonofre64.dslist.domain.entities.UserEntity;

import java.util.List;

import static io.github.brunoonofre64.dslist.utils.ConstantsUnitTest.*;

public class UserStub {

    RoleStub roleStub = new RoleStub();

    public UserEntity buildUserEntity() {
        return UserEntity
                .builder()
                .id(ID_DEFAULT)
                .email(TEXT_DEFAULT)
                .password(TEXT_DEFAULT)
                .roles(List.of(roleStub.buildRoleEntity()))
                .build();
    }

    public UserRequestDTO buildUserRequestDTO() {
        return UserRequestDTO
                .builder()
                .email(TEXT_DEFAULT)
                .password(TEXT_DEFAULT)
                .roleId(List.of(ID_DEFAULT))
                .build();
    }

    public UserUpdateDTO buildUserUpdateDTO() {
        return UserUpdateDTO
                .builder()
                .currentPassword(TEXT_DEFAULT)
                .email(TEXT_DEFAULT)
                .newPassword(TEXT_DEFAULT_2)
                .roleId(List.of(ID_DEFAULT))
                .build();
    }

    public PasswordDTO buildPasswordDTO() {
        return PasswordDTO
                .builder()
                .currentPassword(TEXT_DEFAULT)
                .build();
    }
}
