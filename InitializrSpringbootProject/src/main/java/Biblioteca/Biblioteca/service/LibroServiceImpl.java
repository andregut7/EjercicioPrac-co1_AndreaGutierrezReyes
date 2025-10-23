package Biblioteca.Biblioteca.service;

import Biblioteca.Biblioteca.domain.Libro;
import Biblioteca.Biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }
}