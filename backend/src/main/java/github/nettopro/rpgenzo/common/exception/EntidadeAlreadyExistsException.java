package github.nettopro.rpgenzo.common.exception;

import lombok.Getter;

@Getter
public class EntidadeAlreadyExistsException extends RuntimeException {

    private final Long id;

    public EntidadeAlreadyExistsException(String message, Long id) {

        super(message);
        this.id = id;
    }

}
