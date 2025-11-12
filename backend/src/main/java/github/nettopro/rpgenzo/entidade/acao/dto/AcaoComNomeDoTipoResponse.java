package github.nettopro.rpgenzo.entidade.acao.dto;

import java.util.Set;

import lombok.Data;

@Data
public class AcaoComNomeDoTipoResponse {
    private Integer id;
    private String nome;
    private String descricao;
    private Byte acaoCusto;
    private Boolean ehAcaoLivre;
    private Boolean ehReacao;
    private String reacaoAcionamento;
    private String requerimento;
    private String sucessoCritico;
    private String sucesso;
    private String falha;
    private String falhaCritica;
    private Set<String> tipoNomes;
}
