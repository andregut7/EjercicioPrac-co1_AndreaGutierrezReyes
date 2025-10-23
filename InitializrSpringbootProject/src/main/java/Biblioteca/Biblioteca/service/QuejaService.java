package Biblioteca.Biblioteca.service;

import Biblioteca.Biblioteca.domain.Queja;
import java.util.List;

public interface QuejaService {
    List<Queja> listarTodos();
    Queja guardar(Queja queja);
    Queja buscarPorId(Long id);
    void eliminar(Long id);
}