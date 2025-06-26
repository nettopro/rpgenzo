package github.nettopro.rpgenzo.entidade.acao.dto;

import lombok.Value;

@Value
public class AcaoSemTipoResponse {

    private Integer id;

    private String nome;

    private String descricao;

    private Byte acaoCusto;

    private Byte acaoLivreCusto;

    private String reacaoAcionamento;

    private String requerimento;
}
