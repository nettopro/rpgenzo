package github.nettopro.rpgenzo.tipo;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoService {

    private final TipoRepository tipoRepository;

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
