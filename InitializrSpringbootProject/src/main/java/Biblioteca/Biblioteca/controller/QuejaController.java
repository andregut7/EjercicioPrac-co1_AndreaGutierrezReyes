package Biblioteca.Biblioteca.controller;

import Biblioteca.Biblioteca.domain.Queja;
import Biblioteca.Biblioteca.service.QuejaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/queja")
public class QuejaController {

    private final QuejaService quejaService;

    public QuejaController(QuejaService quejaService) {
        this.quejaService = quejaService;
    }

    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("queja", new Queja());
        return "queja_formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Queja queja) {
        quejaService.guardar(queja);
        return "redirect:/";
    }

    @GetMapping("/listado")
    public String listar(Model model) {
        model.addAttribute("quejas", quejaService.listarTodos());
        return "queja_listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        quejaService.eliminar(id);
        return "redirect:/queja/listado";
    }
}