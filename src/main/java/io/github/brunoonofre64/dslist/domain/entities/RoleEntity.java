package io.github.brunoonofre64.dslist.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_role")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String roleName;

    @PrePersist
    private void prePersis() {
        this.id = UUID.randomUUID().toString();
    }
}
