package github.nettopro.rpgenzo.service.acoes;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.nettopro.rpgenzo.model.acoes.Acao;
import github.nettopro.rpgenzo.repository.acoes.AcaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcaoService {

    private final AcaoRepository acaoRepository;

    @Transactional
    public Acao criarESalvarAcao(Acao acao) {
        return acaoRepository.save(acao);
    }

    @Transactional
    public void excluirAcao(Long id) {
        if(!acaoRepository.existsById(id)) {
            throw new NoSuchElementException("Tipo com ID " + id + " não encontrado.");
        }
        acaoRepository.deleteById(id);
    }
}

