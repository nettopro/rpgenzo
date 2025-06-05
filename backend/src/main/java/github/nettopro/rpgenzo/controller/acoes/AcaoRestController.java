package github.nettopro.rpgenzo.controller.acoes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.nettopro.rpgenzo.service.acoes.AcaoService;

@RestController
@RequestMapping("/api/acoes")
public class AcaoRestController {

    private final AcaoService acaoService;

    public AcaoRestController(AcaoService acaoService) {
        this.acaoService = acaoService;
    }
}
