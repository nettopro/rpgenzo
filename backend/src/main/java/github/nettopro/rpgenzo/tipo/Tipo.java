package github.nettopro.rpgenzo.tipo;

import java.util.HashSet;
import java.util.Set;

import github.nettopro.rpgenzo.acao.Acao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
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

    @ManyToMany(mappedBy = "acaoTipos")
    @ToString.Exclude
    private Set<Acao> acoes = new HashSet<>();
    
    @Builder
    public Tipo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
