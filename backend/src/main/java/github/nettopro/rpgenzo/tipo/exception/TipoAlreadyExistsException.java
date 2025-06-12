package github.nettopro.rpgenzo.tipo.exception;

import github.nettopro.rpgenzo.common.exception.EntidadeAlreadyExistsException;

public class TipoAlreadyExistsException extends EntidadeAlreadyExistsException{
    
    public TipoAlreadyExistsException(Long id) {

        super("Tipo já existente", id);
    }
}
