package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.UserDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.RoleEntity;
import io.github.brunoonofre64.dslist.domain.entities.UserEntity;
import io.github.brunoonofre64.dslist.domain.enums.CodeMessage;
import io.github.brunoonofre64.dslist.domain.exceptions.InvalidPasswordException;
import io.github.brunoonofre64.dslist.domain.exceptions.RoleEmptyException;
import io.github.brunoonofre64.dslist.domain.exceptions.UserListIsEmpty;
import io.github.brunoonofre64.dslist.domain.exceptions.UsernameAlreadyExists;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.RoleRepository;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(CodeMessage.USER_NOT_FOUND.getValue()));

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());

        return new User(user.getEmail(), user.getPassword(), authorities);
    }

    public UserDTO save(UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getEmail() != null && userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new UsernameAlreadyExists(CodeMessage.USERNAME_ALREADY_EXISTS);
        }

        UserEntity userEntity = userRequestDTO.toEntity();

        List<RoleEntity> roleEntity = roleRepository.findByIdIn(userRequestDTO.getRoleId());
        if (CollectionUtils.isEmpty(roleEntity)) {
            throw new RoleEmptyException(CodeMessage.ROLE_NOT_FOUND);
        }

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(roleEntity);

        userRepository.save(userEntity);

        return new UserDTO(userEntity);
    }

    @Transactional
    public UserDTO update(String email, UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getEmail() != null && userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new UsernameAlreadyExists(CodeMessage.USERNAME_ALREADY_EXISTS);
        }

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(CodeMessage.USER_NOT_FOUND.getValue()));

        if (userRequestDTO.getRoleId() != null && !CollectionUtils.isEmpty(userRequestDTO.getRoleId())) {
            List<RoleEntity> roleEntity = roleRepository.findByIdIn(userRequestDTO.getRoleId());

            if (CollectionUtils.isEmpty(roleEntity)) {
                throw new RoleEmptyException(CodeMessage.ROLE_NOT_FOUND);
            }
            user.setRoles(roleEntity);
        }

        if (!passwordEncoder.matches(userRequestDTO.getCurrentPassword(), user.getPassword())) {
            throw new InvalidPasswordException(CodeMessage.CURRENT_PASSWORD_INCORRECT);
        }

        if (userRequestDTO.getEmail() != null) {
            user.setEmail(userRequestDTO.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return new UserDTO(user);
    }

    public void delete(String email) {
        try {
            userRepository.deleteByEmail(email);
        } catch (Exception ex) {
            throw new UsernameNotFoundException(CodeMessage.USER_NOT_FOUND.getValue());
        }
    }

    public List<UserDTO> findAll() {
        List<UserEntity> users = userRepository.findAll();

        if (CollectionUtils.isEmpty(users)) {
            throw new UserListIsEmpty(CodeMessage.USER_LIST_IS_EMPTY);
        }

        return users
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
}
