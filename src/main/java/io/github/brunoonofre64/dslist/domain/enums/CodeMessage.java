package io.github.brunoonofre64.dslist.domain.enums;

import lombok.Getter;

@Getter
public enum CodeMessage {

    EMPTY_LIST("EMPTY_LIST"),
    GAME_NOT_FOUND("GAME_NOT_FOUND"),
    GAME_LIST_NOT_FOUND("GAME_LIST_NOT_FOUND"),
    USER_NOT_FOUND("USER_NOT_FOUND"),
    USER_LIST_IS_EMPTY("USER_LIST_IS_EMPTY");

    final String value;

    CodeMessage(String value) {
        this.value = value;
    }
}