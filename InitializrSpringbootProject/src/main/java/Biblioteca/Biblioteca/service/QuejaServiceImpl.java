package Biblioteca.Biblioteca.service;

import Biblioteca.Biblioteca.domain.Queja;
import Biblioteca.Biblioteca.repository.QuejaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuejaServiceImpl implements QuejaService {

    private final QuejaRepository quejaRepository;

    public QuejaServiceImpl(QuejaRepository quejaRepository) {
        this.quejaRepository = quejaRepository;
    }

    @Override
    public List<Queja> listarTodos() {
        return quejaRepository.findAll();
    }

    @Override
    public Queja guardar(Queja queja) {
        return quejaRepository.save(queja);
    }

    @Override
    public Queja buscarPorId(Long id) {
        return quejaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        quejaRepository.deleteById(id);
    }
}