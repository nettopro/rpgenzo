package github.nettopro.rpgenzo.entidade.acao.dto;

public record AcaoComNomeDoTipoProjection(
    Integer id,
    String nome,
    String descricao,
    Byte acaoCusto,
    Boolean ehAcaoLivre,
    Boolean ehReacao,
    String reacaoAcionamento,
    String requerimento,
    String sucessoCritico,
    String sucesso,
    String falha,
    String falhaCritica,
    String tipoNome
) {

}
