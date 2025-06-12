package github.nettopro.rpgenzo.entidade.tipo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tipos")
@RequiredArgsConstructor
public class TipoRestController {
    
    private final TipoService tipoService;

    @PostMapping
    public ResponseEntity<String> criarTipo(@Valid @RequestBody TipoRequest tipoRequest) { 
        tipoService.criarTipo(tipoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tipo criado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarTipo(@PathVariable("id") Long id, @Valid @RequestBody TipoRequest tipoRequest) {
        tipoService.atualizarTipo(id, tipoRequest);
        return ResponseEntity.ok("Tipo atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipo(@PathVariable("id") Long id) {
        tipoService.excluirTipo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoResponse> buscarTipoPorId(@PathVariable("id") Long id) {
        TipoResponse tipoResponse = tipoService.buscarTipoPorId(id);
        return ResponseEntity.ok(tipoResponse);
    }

    @GetMapping
    public ResponseEntity<List<TipoResponse>> buscarTodosTipos() {
        List<TipoResponse> tipos = tipoService.buscarTodosTipos();
        return ResponseEntity.ok(tipos);
    }
}
