package io.github.brunoonofre64.dslist.domain.exceptions;

import io.github.brunoonofre64.dslist.domain.enums.CodeMessage;
import lombok.Getter;

@Getter
public class GameNotFoundException extends RuntimeException {

    final CodeMessage message;
    public GameNotFoundException(CodeMessage message) {
        this.message = message;
    }
}
