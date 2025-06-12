package github.nettopro.rpgenzo.tipo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
}
