package github.nettopro.rpgenzo.tipo.exception;

import github.nettopro.rpgenzo.common.exception.EntidadeNotFoundException;

public class TipoNotFoundException extends EntidadeNotFoundException {

    public TipoNotFoundException(Long id) {

        super("Tipo não encontrado.", id);
    }

}
