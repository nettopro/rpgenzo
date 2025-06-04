package github.nettopro.rpgenzo.controller.acoes;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import github.nettopro.rpgenzo.model.acoes.Tipo;
import github.nettopro.rpgenzo.service.acoes.TipoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipos")
public class TipoRestController {
    private final TipoService tipoService;

    public TipoRestController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @PostMapping
    public ResponseEntity<?> criarTipo(@Valid @RequestBody Tipo tipo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        tipoService.criarESalvarTipo(tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tipo criado com sucesso");
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
