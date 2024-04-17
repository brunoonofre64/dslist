package io.github.brunoonofre64.dslist.domain.dto;

import io.github.brunoonofre64.dslist.domain.entities.UserEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @Email
    private String email = null;
    private String password;
    private List<String> roleId = new ArrayList<>();

    public UserEntity toEntity() {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
