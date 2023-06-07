package io.github.brunoonofre64.dslist.domain.dto;

import lombok.*;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    @Email
    private String email = null;
    private String newPassword;
    private List<String> roleId = new ArrayList<>();
    private String currentPassword;
}
