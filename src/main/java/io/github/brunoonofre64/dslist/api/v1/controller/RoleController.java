package io.github.brunoonofre64.dslist.api.v1.controller;

import io.github.brunoonofre64.dslist.domain.dto.RoleRequestDTO;
import io.github.brunoonofre64.dslist.infrastructure.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody RoleRequestDTO roleRequestDTO) {
        roleService.save(roleRequestDTO);
    }
}
