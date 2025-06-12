package github.nettopro.rpgenzo.common;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import github.nettopro.rpgenzo.common.exception.EntidadeAlreadyExistsException;
import github.nettopro.rpgenzo.common.exception.EntidadeNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntidadeNotFoundException(EntidadeNotFoundException ex, WebRequest request) {

        String requestPath = ((ServletWebRequest) request).getRequest().getRequestURI();

        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Entidade não encontrada",
            ex.getMessage(),
            requestPath
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntidadeAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEntidadeAlreadyExistsException(EntidadeAlreadyExistsException ex, WebRequest request) {

        String requestPath = ((ServletWebRequest) request).getRequest().getRequestURI();

        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.CONFLICT.value(),
            "Entidade já existente",
            ex.getMessage(),
            requestPath
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
