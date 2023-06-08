package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.RoleRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;
import io.github.brunoonofre64.dslist.domain.exceptions.RoleAlreadyExistsException;
import io.github.brunoonofre64.dslist.domain.exceptions.RoleEmptyException;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.RoleRepository;
import io.github.brunoonofre64.dslist.stubs.RoleStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class RoleServiceTest {

    @InjectMocks
    private RoleService roleService;
    @Mock
    private RoleRepository roleRepository;

    private RoleRequestDTO roleRequestDTO;
    private RoleEntity roleEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        roleService = new RoleService(roleRepository);
        this.buildArrangeOfTests();
    }

    RoleStub roleStub = new RoleStub();

    @Test
    @DisplayName("Must save role with success")
    void mustSaveRoleWithSuccess() {
        when(roleRepository.existsByRoleName(any())).thenReturn(false);

        roleRepository.save(roleEntity);

        verify(roleRepository, times(1)).save(any(RoleEntity.class));
    }

    @Test
    @DisplayName("Must throw an error by role is null")
    void mustThrowErrorByRoleIsNull() {
        roleRequestDTO.setRoleName(null);

        Throwable ex = assertThrows(RoleEmptyException.class,
                () -> roleService.save(roleRequestDTO));

        assertEquals(RoleEmptyException.class, ex.getClass());

    }

    @Test
    @DisplayName("Must throw an error role already exists")
    void mustThrowErrorByRoleAlreadyExists() {
        when(roleRepository.existsByRoleName(any())).thenReturn(true);

        Throwable ex = assertThrows(RoleAlreadyExistsException.class,
                () -> roleService.save(roleRequestDTO));

        assertEquals(RoleAlreadyExistsException.class, ex.getClass());
    }

    private void buildArrangeOfTests() {
        roleRequestDTO = roleStub.buildRoleRequestDTO();
        roleEntity = roleStub.buildRoleEntity();
    }
}
