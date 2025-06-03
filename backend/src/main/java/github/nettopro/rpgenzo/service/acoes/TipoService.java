package github.nettopro.rpgenzo.service.acoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.nettopro.rpgenzo.model.acoes.Tipo;
import github.nettopro.rpgenzo.repository.acoes.TipoRepository;
import jakarta.validation.Valid;

@Service
public class TipoService {

    @Autowired
    TipoRepository tipoRepository;

    @Transactional
    public Tipo criarESalvarTipo(@Valid Tipo tipo) {
        return tipoRepository.save(tipo);
    }
}
