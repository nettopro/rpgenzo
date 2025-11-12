package github.nettopro.rpgenzo.entidade.tipo;

import java.util.HashSet;
import java.util.Set;

import github.nettopro.rpgenzo.entidade.acao.Acao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tipos")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_seq")
    @SequenceGenerator(name = "tipo_seq", sequenceName = "tipo_seq", allocationSize = 10)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(unique = true)
    @NotBlank(message = "Necessita de nome!")
    private String nome;

    @Column(length = 2000)
    @NotBlank(message = "Necessita de descrição!")
    private String descricao;

    @NotBlank(message = "Necessita de grupo!")
    private String grupo;

    @ManyToMany(mappedBy = "acaoTipos")
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private Set<Acao> acoes = new HashSet<>();

}
