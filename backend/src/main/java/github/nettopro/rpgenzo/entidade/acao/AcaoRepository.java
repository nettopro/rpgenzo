package github.nettopro.rpgenzo.entidade.acao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import github.nettopro.rpgenzo.entidade.acao.dto.AcaoComNomeDoTipoProjection;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Integer> {

    Optional<Acao> findByNomeIgnoreCase(String nome);

    @Query("""
            SELECT new github.nettopro.rpgenzo.entidade.acao.dto.AcaoComNomeDoTipoProjection(
                a.id,
                a.nome,
                a.descricao,
                a.acaoCusto,
                a.acaoLivreCusto,
                a.reacaoAcionamento,
                a.requerimento,
                t.nome
            )
            FROM Acao a
            LEFT JOIN a.acaoTipos t
            WHERE a.id = :id
            """)
    List<AcaoComNomeDoTipoProjection> findAcaoWithTipoNomeById(@Param("id") Integer id);

}
