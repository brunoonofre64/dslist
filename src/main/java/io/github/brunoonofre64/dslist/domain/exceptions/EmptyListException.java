package io.github.brunoonofre64.dslist.domain.exceptions;

import io.github.brunoonofre64.dslist.domain.enums.CodeMessage;
import lombok.Getter;

@Getter
public class EmptyListException extends RuntimeException{

    final CodeMessage message;

   public EmptyListException(CodeMessage message) {
       this.message = message;
   }
}
