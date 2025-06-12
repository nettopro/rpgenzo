package github.nettopro.rpgenzo.entidade.acao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/acoes")
@RequiredArgsConstructor
public class AcaoRestController {

    private final AcaoService acaoService;

}
