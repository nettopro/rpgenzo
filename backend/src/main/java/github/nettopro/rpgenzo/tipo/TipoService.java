package github.nettopro.rpgenzo.tipo;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.nettopro.rpgenzo.common.exception.EntidadeAlreadyExistsException;
import github.nettopro.rpgenzo.common.exception.EntidadeNotFoundException;
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
            throw new EntidadeAlreadyExistsException("Tipo já existe com ID " + tipoExistente.get().getId());
        }
        Tipo tipo = tipoMapper.toTipo(tipoRequest);
        return tipoRepository.save(tipo);
    }

    public void excluirTipo(Long id) {
        if(!tipoRepository.existsById(id)) {
            throw new EntidadeNotFoundException("Tipo não encontrado com ID " + id);
        }
        tipoRepository.deleteById(id);
    }
}
