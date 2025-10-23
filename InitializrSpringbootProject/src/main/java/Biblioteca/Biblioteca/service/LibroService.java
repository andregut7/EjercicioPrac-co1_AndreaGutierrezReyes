package Biblioteca.Biblioteca.service;

import Biblioteca.Biblioteca.domain.Libro;
import java.util.List;

public interface LibroService {

    List<Libro> listarTodos();        // ya existía

    Libro guardar(Libro libro);       // guardar un libro

    Libro buscarPorId(Long id);       // buscar libro por ID

    void eliminar(Long id);           // eliminar libro por ID
}