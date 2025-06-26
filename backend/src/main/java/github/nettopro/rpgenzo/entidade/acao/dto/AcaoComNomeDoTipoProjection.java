package github.nettopro.rpgenzo.entidade.acao.dto;

public record AcaoComNomeDoTipoProjection(
    Integer id,
    String nome,
    String descricao,
    Byte acaoCusto,
    Byte acaoLivreCusto,
    String reacaoAcionamento,
    String requerimento,
    String tipoNome
) {

}
