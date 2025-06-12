package github.nettopro.rpgenzo.entidade.tipo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

    Optional<Tipo> findByNomeIgnoreCase(String nome);
}
