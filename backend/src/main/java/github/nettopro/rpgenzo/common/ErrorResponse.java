package github.nettopro.rpgenzo.common;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    private final LocalDateTime timestamp;

    private final int status;

    private final String error;

    private final String message;

    private Long id;
}
