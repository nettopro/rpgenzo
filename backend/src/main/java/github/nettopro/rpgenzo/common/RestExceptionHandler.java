package github.nettopro.rpgenzo.common;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import github.nettopro.rpgenzo.common.exception.EntidadeAlreadyExistsException;
import github.nettopro.rpgenzo.common.exception.EntidadeNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntidadeNotFoundException(EntidadeNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Entidade não encontrada.",
            ex.getMessage(),
            ex.getId()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntidadeAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEntidadeAlreadyExistsException(EntidadeAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.CONFLICT.value(),
            "Entidade já existente.",
            ex.getMessage(),
            ex.getId()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
