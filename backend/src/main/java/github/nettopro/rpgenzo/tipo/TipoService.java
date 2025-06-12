package github.nettopro.rpgenzo.tipo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoService {

    private final TipoRepository tipoRepository;
    private final TipoMapper tipoMapper;

    @Transactional
    public Tipo criarTipo(TipoRequest tipoRequest) {
        if(tipoRepository.existsByNome(tipoRequest.getNome())) {
            throw new IllegalArgumentException("Já existe um tipo com o nome: " + tipoRequest.getNome());
        }
        Tipo tipo = tipoMapper.toTipo(tipoRequest);
        return tipoRepository.save(tipo);
    }

    @Transactional
    public void excluirTipo(Long id) {
        if(!tipoRepository.existsById(id)) {
            throw new TipoNotFoundException(id);
        }
        tipoRepository.deleteById(id);
    }
}
