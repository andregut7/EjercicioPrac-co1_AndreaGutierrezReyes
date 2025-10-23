package Biblioteca.Biblioteca.service;

import Biblioteca.Biblioteca.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    List<Categoria> obtenerCategorias();
    
    Categoria obtenerCategoriaPorId(Long idCategoria);
    
    void guardarCategoria(Categoria categoria);
    
    void eliminarCategoria(Long idCategoria);
}