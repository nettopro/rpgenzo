package github.nettopro.rpgenzo.entidade.tipo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {

    Optional<Tipo> findByNomeIgnoreCase(String nome);

    @Query("SELECT t FROM Tipo t WHERE t.id = :id")
    Optional<Tipo> findTipoById(Integer id);

    @Query("SELECT t FROM Tipo t")
    List<Tipo> findAllTipos();
}
