package github.nettopro.rpgenzo.tipo;

import github.nettopro.rpgenzo.common.EntidadeNotFoundException;

public class TipoNotFoundException extends EntidadeNotFoundException {

    public TipoNotFoundException(Long id) {

        super("Tipo com id " + id + " não encontrado.");
    }

}
