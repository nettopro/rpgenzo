package github.nettopro.rpgenzo.entidade.tipo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TipoRequest {

    @NotBlank(message = "Necessita de nome!")
    private String nome;

    @NotBlank(message = "Necessita de descrição!")
    @Size(max = 2000, message = "Descrição não pode ter mais de 2000 caracteres!")
    private String descricao;
}
