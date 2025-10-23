package Biblioteca.Biblioteca.controller;

import Biblioteca.Biblioteca.domain.Libro;
import Biblioteca.Biblioteca.service.LibroService;
import Biblioteca.Biblioteca.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libro")
public class LibroController {

    private final LibroService libroService;
    private final CategoriaService categoriaService;

    public LibroController(LibroService libroService, CategoriaService categoriaService) {
        this.libroService = libroService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listado")
    public String listar(Model model) {
        model.addAttribute("libros", libroService.listarTodos());
        return "libro_listado";
    }

    @GetMapping("/nuevo")
    public String nuevoFormulario(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("categorias", categoriaService.obtenerCategorias()); // CORREGIDO
        return "libro_formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Libro libro) {
        libroService.guardar(libro);
        return "redirect:/libro/listado";
    }

    @GetMapping("/editar/{id}")
    public String editarFormulario(@PathVariable Long id, Model model) {
        model.addAttribute("libro", libroService.buscarPorId(id));
        model.addAttribute("categorias", categoriaService.obtenerCategorias()); // CORREGIDO
        return "libro_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
        return "redirect:/libro/listado";
    }
}