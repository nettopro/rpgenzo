package github.nettopro.rpgenzo.entidade.acao.dto;

import java.util.Set;

import lombok.Data;

@Data
public class AcaoComNomeDoTipoResponse {
    private Integer id;
    private String nome;
    private String descricao;
    private Byte acaoCusto;
    private Byte acaoLivreCusto;
    private String reacaoAcionamento;
    private String requerimento;
    private Set<String> tipoNomes;
}
