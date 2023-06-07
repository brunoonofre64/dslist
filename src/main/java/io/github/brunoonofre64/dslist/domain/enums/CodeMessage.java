package io.github.brunoonofre64.dslist.domain.enums;

import lombok.Getter;

@Getter
public enum CodeMessage {

    EMPTY_LIST("EMPTY_LIST"),
    GAME_NOT_FOUND("GAME_NOT_FOUND"),
    GAME_LIST_NOT_FOUND("GAME_LIST_NOT_FOUND"),
    USER_NOT_FOUND("USER_NOT_FOUND"),
    USER_LIST_IS_EMPTY("USER_LIST_IS_EMPTY"),
    CURRENT_PASSWORD_INCORRECT("CURRENT_PASSWORD_INCORRECT"),
    USERNAME_ALREADY_EXISTS("USERNAME_ALREADY_EXISTS"),
    ROLE_EMPTY("ROLE_EMPTY"),
    ROLE_ALREADY_EXISTS("ROLE_ALREADY_EXISTS"),
    ROLE_NOT_FOUND("ROLE_NOT_FOUND");

    final String value;

    CodeMessage(String value) {
        this.value = value;
    }
}