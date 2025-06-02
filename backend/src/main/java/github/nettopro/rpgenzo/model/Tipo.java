package github.nettopro.rpgenzo.model;

import java.util.HashSet;
import java.util.Set;

import github.nettopro.rpgenzo.model.acoes.Acao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tipos")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tipo {

    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Necessita de nome!")
    private String nome;

    @Column(columnDefinition = "TEXT")
    @Lob
    private String descricao;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "acaoTipos")
    private Set<Acao> acoes = new HashSet<>();
}
