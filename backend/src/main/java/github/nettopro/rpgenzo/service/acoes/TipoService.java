package github.nettopro.rpgenzo.service.acoes;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.nettopro.rpgenzo.model.acoes.Tipo;
import github.nettopro.rpgenzo.repository.acoes.TipoRepository;

@Service
public class TipoService {

    private final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Transactional
    public Tipo criarESalvarTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Transactional
    public void excluirTipo(Long id) {
        if(!tipoRepository.existsById(id)) {
            throw new NoSuchElementException("Tipo com ID " + id + " não encontrado.");
        }
        tipoRepository.deleteById(id);
    }
}
