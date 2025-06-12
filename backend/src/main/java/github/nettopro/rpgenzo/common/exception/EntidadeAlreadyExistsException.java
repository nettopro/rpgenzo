package github.nettopro.rpgenzo.common.exception;

import lombok.Getter;

@Getter
public class EntidadeAlreadyExistsException extends RuntimeException {

    public EntidadeAlreadyExistsException(String message) {
        super(message);
    }

}
