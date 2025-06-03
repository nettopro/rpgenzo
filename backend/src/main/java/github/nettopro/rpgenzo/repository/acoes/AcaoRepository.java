package github.nettopro.rpgenzo.repository.acoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.nettopro.rpgenzo.model.acoes.Acao;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Long> {

}
