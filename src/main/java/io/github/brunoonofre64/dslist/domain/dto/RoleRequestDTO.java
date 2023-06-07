package io.github.brunoonofre64.dslist.domain.dto;

import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class RoleRequestDTO {
    private String roleName;

    public RoleEntity toEntity() {
        RoleEntity entity = new RoleEntity();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
