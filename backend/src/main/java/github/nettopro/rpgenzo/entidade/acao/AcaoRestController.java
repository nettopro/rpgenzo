package github.nettopro.rpgenzo.entidade.acao;

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
@RequestMapping("/api/acoes")
@RequiredArgsConstructor
public class AcaoRestController {

    private final AcaoService acaoService;

    @PostMapping
    public ResponseEntity<String> criarAcao(@Valid @RequestBody AcaoRequest acaoRequest) {
        acaoService.criarAcao(acaoRequest); 
        return ResponseEntity.status(HttpStatus.CREATED).body("Ação criada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAcao(@PathVariable("id") Integer id, @Valid @RequestBody AcaoRequest acaoRequest) {
        acaoService.atualizarAcao(id, acaoRequest);
        return ResponseEntity.ok("Ação atualizada com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipo(@PathVariable("id") Integer id) {
        acaoService.excluirAcao(id);
        return ResponseEntity.noContent().build();
    }
}
