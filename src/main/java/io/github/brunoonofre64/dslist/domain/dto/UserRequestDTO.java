package io.github.brunoonofre64.dslist.domain.dto;

import io.github.brunoonofre64.dslist.domain.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @Email
    private String email = null;
    private String password;
    private List<String> roleId = new ArrayList<>();
    private String currentPassword = null;

    public UserEntity toEntity() {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
