package github.nettopro.rpgenzo.entidade.acao.dto;

import java.util.Set;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AcaoRequest {

    @NotBlank(message = "Necessita de nome!")
    private String nome;

    @NotBlank(message = "Necessita de descrição!")
    @Size(max = 2000, message = "Descrição não pode ter mais de 2000 caracteres!")
    private String descricao;

    @NotEmpty(message = "Necessita de pelo menos um tipo na ação!")
    private Set<Integer> acaoTiposIds;

    @Min(value = 0, message = "Custo deve ser maior ou igual a zero!")
    private Byte acaoCusto;

    private Boolean acaoLivreCusto;

    private String reacaoAcionamento;

    private String requerimento;
}
