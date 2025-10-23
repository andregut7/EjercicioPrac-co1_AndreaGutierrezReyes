package Biblioteca.Biblioteca.service;

import Biblioteca.Biblioteca.repository.CategoriaRepository;
import Biblioteca.Biblioteca.domain.Categoria;
import Biblioteca.Biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> obtenerCategorias() {
        return categoriaRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Categoria obtenerCategoriaPorId(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }
    
    @Override
    @Transactional
    public void guardarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
    
    @Override
    @Transactional
    public void eliminarCategoria(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}