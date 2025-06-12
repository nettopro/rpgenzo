package github.nettopro.rpgenzo.tipo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoResponse {

    private Long id;
    private String nome;
    private String descricao;

}
