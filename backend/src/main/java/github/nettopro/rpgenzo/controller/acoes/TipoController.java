package github.nettopro.rpgenzo.controller.acoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import github.nettopro.rpgenzo.model.acoes.Tipo;
import github.nettopro.rpgenzo.service.acoes.TipoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tipo")
public class TipoController {

    private final TipoService tipoService;

    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tipo", Tipo.builder().build());
        return "tipo-form";
    }

    @PostMapping("/cadastro")
    public String criarTipo(@Valid @ModelAttribute("tipo") Tipo tipo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "tipo-form";
        }

        tipoService.criarESalvarTipo(tipo);
        return "redirect:/tipo/?cadastroSucesso";
    }
}
