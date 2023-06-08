package io.brunoonofre64.stubs;

import io.github.brunoonofre64.dslist.domain.dto.UserRequestDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserUpdateDTO;
import io.github.brunoonofre64.dslist.domain.entities.UserEntity;

import java.util.List;

import static io.brunoonofre64.utils.ConstantesIntegrationTest.*;

public class UserStubIntegration {

    public UserEntity buildUserEntity() {
        return UserEntity
                .builder()
                .email(USER_EMAIL)
                .password(PASSWORD)
                .build();
    }

    public UserRequestDTO buildUserRequestDTO(List<String> roleId) {
        return UserRequestDTO
                .builder()
                .email(USER_EMAIL)
                .password(PASSWORD)
                .roleId(roleId)
                .build();
    }

    public UserUpdateDTO buildUserRequestDTOUpdate(List<String> roleId) {
        return UserUpdateDTO
                .builder()
                .email(GUEST_EMAIL)
                .newPassword(PASSWORD_2)
                .roleId(roleId)
                .currentPassword(PASSWORD)
                .build();
    }
}
