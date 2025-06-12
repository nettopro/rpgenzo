package github.nettopro.rpgenzo.entidade.acao;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AcaoService {

    private final AcaoRepository acaoRepository;

    public Acao criarESalvarAcao(Acao acao) {
        return acaoRepository.save(acao);
    }

    public void excluirAcao(Long id) {
        if(!acaoRepository.existsById(id)) {
            throw new NoSuchElementException("Tipo com ID " + id + " não encontrado.");
        }
        acaoRepository.deleteById(id);
    }
}

