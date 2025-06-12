package github.nettopro.rpgenzo.entidade.acao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Long> {

    Optional<Acao> findByNomeIgnoreCase(String nome);
}
