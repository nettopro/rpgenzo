package github.nettopro.rpgenzo.controller.acoes;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import github.nettopro.rpgenzo.service.acoes.TipoService;

@RestController
@RequestMapping("/api/tipo")
public class TipoRestController {
    private final TipoService tipoService;

    public TipoRestController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipo(@PathVariable("id") Long id) {
        try {
            tipoService.excluirTipo(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
