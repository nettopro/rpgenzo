package github.nettopro.rpgenzo.entidade.tipo.dto;

import github.nettopro.rpgenzo.entidade.tipo.TipoGrupo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TipoRequest {

    @NotBlank(message = "Necessita de nome!")
    private String nome;

    @NotBlank(message = "Necessita de descrição!")
    @Size(max = 2000, message = "Descrição não pode ter mais de 2000 caracteres!")
    private String descricao;

    @NotNull(message = "Necessita de grupo!")
    @Enumerated(EnumType.STRING)
    private TipoGrupo grupo;
}
