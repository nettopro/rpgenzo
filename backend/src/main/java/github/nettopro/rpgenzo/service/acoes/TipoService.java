package github.nettopro.rpgenzo.service.acoes;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.nettopro.rpgenzo.model.acoes.Tipo;
import github.nettopro.rpgenzo.repository.acoes.TipoRepository;

@Service
public class TipoService {

    @Autowired
    TipoRepository tipoRepository;

    @Transactional
    public Tipo criarESalvarTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public void excluirTipo(Long id) {
        if(!tipoRepository.existsById(id)) {
            throw new NoSuchElementException("Tipo com ID " + id + " não encontrado.");
        }
        tipoRepository.deleteById(id);
    }
}
