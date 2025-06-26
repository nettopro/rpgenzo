package github.nettopro.rpgenzo.entidade.acao.dto;

import java.util.Set;

public record AcaoComNomeDoTipoResponse(
    Integer id,
    String nome,
    String descricao,
    Byte acaoCusto,
    Byte acaoLivreCusto,
    String reacaoAcionamento,
    String requerimento,
    Set<String> tipoNomes
) {

}
