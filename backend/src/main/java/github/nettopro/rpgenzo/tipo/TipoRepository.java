package github.nettopro.rpgenzo.tipo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

    Set<Tipo> findByNomeIgnoreCase(String nome);
}
