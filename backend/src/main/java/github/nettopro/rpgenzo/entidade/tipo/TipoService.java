package github.nettopro.rpgenzo.entidade.tipo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.nettopro.rpgenzo.entidade.exception.EntidadeAlreadyExistsException;
import github.nettopro.rpgenzo.entidade.exception.EntidadeNotFoundException;
import github.nettopro.rpgenzo.entidade.tipo.dto.TipoRequest;
import github.nettopro.rpgenzo.entidade.tipo.dto.TipoResponse;
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

    public Tipo atualizarTipo(Integer id, TipoRequest tipoRequest) {
        Tipo tipoAtual = tipoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("Tipo não encontrado com ID " + id));

        if (!tipoAtual.getNome().equalsIgnoreCase(tipoRequest.getNome())) { 
            Optional<Tipo> tipoExistente = tipoRepository.findByNomeIgnoreCase(tipoRequest.getNome());
            // Verifica se já existe um tipo com o mesmo nome, mas com ID diferente
            // Isso evita conflitos ao atualizar o nome de um tipo existente
            if (tipoExistente.isPresent() && !tipoExistente.get().getId().equals(id)) {
                throw new EntidadeAlreadyExistsException("Tipo já existe com ID " + tipoExistente.get().getId());
            }
        }
        
        tipoMapper.updateTipoFromRequest(tipoRequest, tipoAtual);
        return tipoRepository.save(tipoAtual);
    }

    public void excluirTipo(Integer id) {
        if(!tipoRepository.existsById(id)) {
            throw new EntidadeNotFoundException("Tipo não encontrado com ID " + id);
        }
        tipoRepository.deleteById(id);
    }

    public TipoResponse buscarTipoPorId(Integer id) {
        TipoResponse tipoEncontrado = tipoRepository.findTipoById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("Tipo não encontrado com ID " + id));
            
        return tipoEncontrado;
    }

    public List<TipoResponse> buscarTodosTipos() {
        List<TipoResponse> listaTipos = tipoRepository.findAllTipos();

        if (listaTipos.isEmpty()) {
            throw new EntidadeNotFoundException("Nenhum tipo encontrado.");
        } else return listaTipos;
    }
}
