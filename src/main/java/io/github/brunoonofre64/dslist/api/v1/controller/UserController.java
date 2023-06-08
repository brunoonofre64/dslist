package io.github.brunoonofre64.dslist.api.v1.controller;

import io.github.brunoonofre64.dslist.domain.dto.PasswordDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserRequestDTO;
import io.github.brunoonofre64.dslist.domain.dto.UserUpdateDTO;
import io.github.brunoonofre64.dslist.infrastructure.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDTO save(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.save(userRequestDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public UserDTO update(@RequestParam(required = false) String email, @RequestBody UserUpdateDTO userUpdateDTO) {
        return userService.update(email, userUpdateDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(@RequestParam String email,@RequestBody PasswordDTO password) {
        userService.delete(email, password);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

}
