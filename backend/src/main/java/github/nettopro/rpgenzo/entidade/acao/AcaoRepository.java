package github.nettopro.rpgenzo.entidade.acao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import github.nettopro.rpgenzo.entidade.acao.dto.AcaoComNomeDoTipoProjection;
import github.nettopro.rpgenzo.entidade.acao.dto.AcaoSemTipoResponse;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Integer> {

    Optional<Acao> findByNomeIgnoreCase(String nome);

    ///Uso de projection para evitar o carregamento de entidades desnecessárias
    ///Essa query seleciona as acoes com seus tipos, mas apenas com os nomes dos tipos
    @Query("""
            SELECT new github.nettopro.rpgenzo.entidade.acao.dto.AcaoComNomeDoTipoProjection(
                a.id,
                a.nome,
                a.descricao,
                a.acaoCusto,
                a.ehAcaoLivre,
                a.ehReacao,
                a.reacaoAcionamento,
                a.requerimento,
                a.sucessoCritico,
                a.sucesso,
                a.falha,
                a.falhaCritica,
                t.nome
            )
            FROM Acao a
            LEFT JOIN a.acaoTipos t
            WHERE a.id = :id
            """)
    List<AcaoComNomeDoTipoProjection> findAcaoWithTipoNomeById(@Param("id") Integer id);

    @Query("""
            SELECT new github.nettopro.rpgenzo.entidade.acao.dto.AcaoSemTipoResponse(
                a.id,
                a.nome,
                a.descricao,
                a.acaoCusto,
                a.ehAcaoLivre,
                a.ehReacao,
                a.reacaoAcionamento,
                a.requerimento,
                a.sucessoCritico,
                a.sucesso,
                a.falha,
                a.falhaCritica
            )
            FROM Acao a
            WHERE a.id = :id
            """)
    Optional<AcaoSemTipoResponse> findAcaoSemTipoById(Integer id);

    @Query("""
            SELECT new github.nettopro.rpgenzo.entidade.acao.dto.AcaoComNomeDoTipoProjection(
                a.id,
                a.nome,
                a.descricao,
                a.acaoCusto,
                a.ehAcaoLivre,
                a.ehReacao,
                a.reacaoAcionamento,
                a.requerimento,
                a.sucessoCritico,
                a.sucesso,
                a.falha,
                a.falhaCritica,
                t.nome
            )
            FROM Acao a
            LEFT JOIN a.acaoTipos t
            """)
    List<AcaoComNomeDoTipoProjection> findAllAcoesComTipo();
}
