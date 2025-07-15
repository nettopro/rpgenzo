package github.nettopro.rpgenzo.entidade.acao;

import java.util.HashSet;
import java.util.Set;

import github.nettopro.rpgenzo.entidade.tipo.Tipo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acao_seq")
    @SequenceGenerator(name = "acao_seq", sequenceName = "acao_seq", allocationSize = 10)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(unique = true)
    @NotBlank(message = "Necessita de nome!")
    private String nome;

    @Column(length = 2000)
    @NotBlank(message = "Necessita de descrição!")
    private String descricao;

    //Relação muitos-para-muitos para os tipos das ações
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "acao_tipo",
            joinColumns = @JoinColumn(name = "acao_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_id")
            )
    @NotEmpty(message = "Necessita de pelo menos um tipo!")
    @ToString.Exclude
    private Set<Tipo> acaoTipos = new HashSet<>();

    @Min(value = 0, message = "Custo deve ser maior ou igual a zero!")
    private Byte acaoCusto;

    private Boolean acaoLivreCusto;

    private String reacaoAcionamento;

    private String requerimento;

}
