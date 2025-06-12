package github.nettopro.rpgenzo.common.exception;

import lombok.Getter;

@Getter
public class EntidadeNotFoundException extends RuntimeException {

    private final Long id;

    public EntidadeNotFoundException(String message, Long id) {

        super(message); 
        this.id = id;
    }
}
