package io.github.brunoonofre64.dslist.infrastructure.service;

import io.github.brunoonofre64.dslist.domain.dto.UserDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserRequestDTO;
import io.github.brunoonofre64.dslist.domain.entities.UserEntity;
import io.github.brunoonofre64.dslist.domain.enums.CodeMessage;
import io.github.brunoonofre64.dslist.domain.exceptions.UserListIsEmpty;
import io.github.brunoonofre64.dslist.infrastructure.jpa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(CodeMessage.USER_NOT_FOUND.getValue()));

        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public UserDTO save(UserRequestDTO userRequestDTO) {
        UserEntity userEntity = userRequestDTO.toEntity();

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        userRepository.save(userEntity);

        return new UserDTO(userEntity);
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
