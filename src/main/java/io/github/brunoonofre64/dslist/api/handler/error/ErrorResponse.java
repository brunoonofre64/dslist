package io.github.brunoonofre64.dslist.api.handler.error;

import io.github.brunoonofre64.dslist.domain.enums.CodeMessage;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String error;
    private LocalDateTime timestamp;
    private int codeStatus;
    private String message;
    private CodeMessage codeMessage;

    public ErrorResponse(String error, LocalDateTime timestamp, int codeStatus, CodeMessage codeMessage) {
        this.error = error;
        this.timestamp = timestamp;
        this.codeStatus = codeStatus;
        this.codeMessage = codeMessage;
    }
}