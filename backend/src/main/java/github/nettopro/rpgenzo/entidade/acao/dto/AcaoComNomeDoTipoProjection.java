package github.nettopro.rpgenzo.entidade.acao.dto;

public record AcaoComNomeDoTipoProjection(
    Integer id,
    String nome,
    String descricao,
    Byte acaoCusto,
    Boolean acaoLivreCusto,
    String reacaoAcionamento,
    String requerimento,
    String tipoNome
) {

}
