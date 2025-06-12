package github.nettopro.rpgenzo.common;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import github.nettopro.rpgenzo.entidade.exception.EntidadeAlreadyExistsException;
import github.nettopro.rpgenzo.entidade.exception.EntidadeNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntidadeNotFoundException(
        EntidadeNotFoundException ex, WebRequest request) {

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
    public ResponseEntity<ErrorResponse> handleEntidadeAlreadyExistsException(
        EntidadeAlreadyExistsException ex, WebRequest request) {

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
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        @NonNull MethodArgumentNotValidException ex, 
        @NonNull HttpHeaders headers,
        @NonNull HttpStatusCode status,
        @NonNull WebRequest request) {

        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        Map<String, String> validationErrors = ex.getBindingResult().getFieldErrors().stream()
        .collect(Collectors.toMap(
            field -> field.getField(),
            field -> field.getDefaultMessage(),
            (mensagem1, mensagem2) -> mensagem1
        ));

    ErrorResponse errorResponse = new ErrorResponse(
        LocalDateTime.now(),
        status.value(),
        "Erro de validação",
        "Verifique os campos inválidos",
        path,
        validationErrors
    );

    return new ResponseEntity<>(errorResponse, headers, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
        ConstraintViolationException ex, WebRequest request) {

        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        Map<String, String> errors = ex.getConstraintViolations().stream()
            .collect(Collectors.toMap(
                violation -> violation.getPropertyPath().toString(),
                ConstraintViolation::getMessage
            ));

        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Erro de validação no banco de dados",
            "Campos inválidos ao persistir entidade",
            path,
            errors
        );

        return ResponseEntity.badRequest().body(errorResponse);
    }
}
