package github.nettopro.rpgenzo.tipo;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.nettopro.rpgenzo.tipo.exception.TipoAlreadyExistsException;
import github.nettopro.rpgenzo.tipo.exception.TipoNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TipoService {

    private final TipoRepository tipoRepository;
    private final TipoMapper tipoMapper;

    public Tipo criarTipo(TipoRequest tipoRequest) {
        Optional<Tipo> tipoExistente = tipoRepository.findByNomeIgnoreCase(tipoRequest.getNome());

        if(tipoExistente.isPresent()) {
            throw new TipoAlreadyExistsException(tipoExistente.get().getId());
        }
        Tipo tipo = tipoMapper.toTipo(tipoRequest);
        return tipoRepository.save(tipo);
    }

    public void excluirTipo(Long id) {
        if(!tipoRepository.existsById(id)) {
            throw new TipoNotFoundException(id);
        }
        tipoRepository.deleteById(id);
    }
}
