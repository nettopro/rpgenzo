package github.nettopro.rpgenzo.repository.acoes;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import github.nettopro.rpgenzo.model.acoes.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

    Set<Tipo> findByNomeIgnoreCase(String nome);
}
