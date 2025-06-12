package github.nettopro.rpgenzo.entidade.acao;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.nettopro.rpgenzo.entidade.exception.EntidadeAlreadyExistsException;
import github.nettopro.rpgenzo.entidade.exception.EntidadeNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AcaoService {

    private final AcaoRepository acaoRepository;
    private final AcaoMapper acaoMapper;

    public Acao criarAcao(AcaoRequest acaoRequest) {
        Optional<Acao> acaoExistente = acaoRepository.findByNomeIgnoreCase(acaoRequest.getNome());

        if (acaoExistente.isPresent()) {
            throw new EntidadeAlreadyExistsException("Ação já existe com ID " + acaoExistente.get().getId());
        }

        Acao acao = acaoMapper.toAcao(acaoRequest);
        return acaoRepository.save(acao);
    }

    public Acao atualizarAcao(Long id, AcaoRequest acaoRequest) {
        Acao acaoAtual = acaoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("Ação não encontrada com ID " + id));
        if (!acaoAtual.getNome().equalsIgnoreCase(acaoRequest.getNome())) {
            Optional<Acao> acaoExistente = acaoRepository.findByNomeIgnoreCase(acaoRequest.getNome());
            
            if (acaoExistente.isPresent() && !acaoExistente.get().getId().equals(id)) {
                throw new EntidadeAlreadyExistsException("Ação já existe com ID " + acaoExistente.get().getId());
            }
        }
        acaoMapper.updateAcaoFromRequest(acaoRequest, acaoAtual);
        return acaoRepository.save(acaoAtual);
    }

    public void excluirAcao(Long id) {
        if(!acaoRepository.existsById(id)) {
            throw new EntidadeNotFoundException("Tipo com ID " + id + " não encontrado.");
        }
        acaoRepository.deleteById(id);
    }
}

