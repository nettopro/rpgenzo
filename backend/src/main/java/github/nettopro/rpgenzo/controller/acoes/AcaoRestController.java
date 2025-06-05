package github.nettopro.rpgenzo.controller.acoes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.nettopro.rpgenzo.service.acoes.AcaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/acoes")
@RequiredArgsConstructor
public class AcaoRestController {

    private final AcaoService acaoService;

}
