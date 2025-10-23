package Biblioteca.Biblioteca.controller;

import Biblioteca.Biblioteca.domain.Libro;
import Biblioteca.Biblioteca.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InicioController {

    private final LibroService libroService;

    public InicioController(LibroService libroService) {
        this.libroService = libroService;
    }

@GetMapping("/")
public String index(Model model) {
    // Trae todos los libros
    List<Libro> libros = libroService.listarTodos(); // <--- aquí

    // Libro destacado (por ejemplo el primero)
    Libro libroDestacado = libros.isEmpty() ? null : libros.get(0);

    // Pasa datos al template
    model.addAttribute("libros", libros);
    model.addAttribute("libroDestacado", libroDestacado);
    model.addAttribute("titulo", "Biblioteca Virtual");

    return "index";
}
}