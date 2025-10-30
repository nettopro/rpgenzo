package github.nettopro.rpgenzo.entidade.acao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.nettopro.rpgenzo.entidade.acao.dto.AcaoComNomeDoTipoProjection;
import github.nettopro.rpgenzo.entidade.acao.dto.AcaoComNomeDoTipoResponse;
import github.nettopro.rpgenzo.entidade.acao.dto.AcaoRequest;
import github.nettopro.rpgenzo.entidade.acao.dto.AcaoSemTipoResponse;
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

    public Acao atualizarAcao(Integer id, AcaoRequest acaoRequest) {
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

    public void excluirAcao(Integer id) {
        if (!acaoRepository.existsById(id)) {
            throw new EntidadeNotFoundException("Tipo com ID " + id + " não encontrado.");
        }
        acaoRepository.deleteById(id);
    }

    public Optional<AcaoSemTipoResponse> buscarAcaoSemTipoPorId(Integer id) {
        Optional<AcaoSemTipoResponse> acaoResponse = acaoRepository.findAcaoSemTipoById(id);
        if (acaoResponse.isEmpty()) {
            throw new EntidadeNotFoundException("Ação não encontrada com ID " + id);
        }

        return acaoResponse;
    }

    public Optional<AcaoComNomeDoTipoResponse> buscarAcaoComNomeDoTipoPorId(Integer id) {
        List<AcaoComNomeDoTipoProjection> acaoProjection = acaoRepository.findAcaoWithTipoNomeById(id);
        if (acaoProjection.isEmpty()) {
            throw new EntidadeNotFoundException("Ação não encontrada com ID " + id);
        }

        AcaoComNomeDoTipoProjection projection = acaoProjection.get(0);
        // Extrai os nomes dos tipos associados à ação
        Set<String> tipoNomes = acaoProjection.stream()
                .map(AcaoComNomeDoTipoProjection::tipoNome)
                .collect(Collectors.toSet());

        AcaoComNomeDoTipoResponse response = acaoMapper.toAcaoComNomeDoTipoResponse(projection);
        response.setTipoNomes(tipoNomes);
        return Optional.of(response);

    }

    public List<AcaoComNomeDoTipoResponse> buscarTodasAcoesComTipo() {
        List<AcaoComNomeDoTipoProjection> acoesProjection = acaoRepository.findAllAcoesComTipo();
        if (acoesProjection.isEmpty()) {
            throw new EntidadeNotFoundException("Nenhuma ação encontrada.");
        }

        Map<Integer, AcaoComNomeDoTipoResponse> mapaFinal = acoesProjection.stream()
            .collect(Collectors.groupingBy(
                AcaoComNomeDoTipoProjection::id, // Agrupa pelo ID
                Collectors.collectingAndThen(
                    Collectors.toList(), // Coleta todas as linhas com o mesmo ID
                    list -> {
                        AcaoComNomeDoTipoProjection baseProjection = list.get(0);
                        AcaoComNomeDoTipoResponse response = acaoMapper.toAcaoComNomeDoTipoResponse(baseProjection);
                        
                        Set<String> tipoNomes = list.stream()
                            .map(AcaoComNomeDoTipoProjection::tipoNome)
                            .collect(Collectors.toSet());
                        
                        response.setTipoNomes(tipoNomes);
                        return response;
                    }
                )
            ));
            
        // Transforma o Map em List<AcaoComNomeDoTipoResponse>
        List<AcaoComNomeDoTipoResponse> listaFinal = new ArrayList<>(mapaFinal.values());

        return listaFinal;
    }
}
