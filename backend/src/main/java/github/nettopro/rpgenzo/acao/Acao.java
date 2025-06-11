package github.nettopro.rpgenzo.acao;

import java.util.HashSet;
import java.util.Set;

import github.nettopro.rpgenzo.tipo.Tipo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "acoes")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Necessita de nome!")
    private String nome;

    @Column(length = 2000)
    @NotBlank(message = "Necessita de descrição!")
    private String descricao;

    //Relação muitos-para-muitos para os tipos das ações
    @ManyToMany
    @JoinTable(name = "acao_tipo",
            joinColumns = @jakarta.persistence.JoinColumn(name = "acao_id"),
            inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "tipo_id"))
    @NotEmpty(message = "Necessita de pelo menos um tipo!")
    @ToString.Exclude
    private Set<Tipo> acaoTipos = new HashSet<>();

    @Min(value = 0, message = "Custo deve ser maior ou igual a zero!")
    private Byte acaoCusto;

    @Min(value = 0, message = "Custo de ação livre deve ser maior ou igual a zero!")
    private Byte acaoLivreCusto;

    private String reacaoAcionamento;

    private String requerimento;

    @Builder
    public Acao(String nome, Byte acaoCusto, Byte acaoLivreCusto, 
                String descricao,String reacaoAcionamento, String requerimento) {
        this.nome = nome;
        this.descricao = descricao;
        this.acaoCusto = acaoCusto != null ? acaoCusto : 0;
        this.acaoLivreCusto = acaoLivreCusto != null ? acaoLivreCusto : 0;
        this.reacaoAcionamento = reacaoAcionamento != null ? reacaoAcionamento : "";
        this.requerimento = requerimento != null ? requerimento : "";
    }

}
