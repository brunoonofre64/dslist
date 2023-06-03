package io.github.brunoonofre64.dslist.api.handler;

import io.github.brunoonofre64.dslist.api.handler.error.ErrorResponse;
import io.github.brunoonofre64.dslist.domain.exceptions.EmptyListException;
import io.github.brunoonofre64.dslist.domain.exceptions.GameNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler  {

    private final ReloadableResourceBundleMessageSource bundleMessageSource;

    private static final String BAD_REQUEST = "Bad Request";
    private static final String NOT_FOUND = "Not Found";
    private static final String VALIDATION_ERROR = "Validation Error";
    private static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    private static final LocalDateTime TIMESTAMP = LocalDateTime.now();


   @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .error(BAD_REQUEST)
                .timestamp(TIMESTAMP)
                .codeStatus(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .error(NOT_FOUND)
                .timestamp(TIMESTAMP)
                .codeStatus(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .error(VALIDATION_ERROR)
                .timestamp(TIMESTAMP)
                .codeStatus(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnknownException(Exception ex) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .error(INTERNAL_SERVER_ERROR)
                .timestamp(TIMESTAMP)
                .codeStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .error(VALIDATION_ERROR)
                .timestamp(TIMESTAMP)
                .codeStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(errors.toString())
                .build();
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmptyListException.class)
    public ResponseEntity<ErrorResponse> handleEmptyListException(EmptyListException ex) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .error(BAD_REQUEST)
                .timestamp(TIMESTAMP)
                .codeStatus(HttpStatus.BAD_REQUEST.value())
                .message(this.getCodeMessage(ex.getMessage()))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGameNotFoundException(GameNotFoundException ex) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .error(BAD_REQUEST)
                .timestamp(TIMESTAMP)
                .codeStatus(HttpStatus.BAD_REQUEST.value())
                .message(this.getCodeMessage(ex.getMessage()))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .error(BAD_REQUEST)
                .timestamp(TIMESTAMP)
                .codeStatus(HttpStatus.BAD_REQUEST.value())
                .message(ex.getCause().toString())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }



    private String getCodeMessage(String codigoMensagem) {
        return bundleMessageSource.getMessage(codigoMensagem, null, LocaleContextHolder.getLocale());
    }
}

