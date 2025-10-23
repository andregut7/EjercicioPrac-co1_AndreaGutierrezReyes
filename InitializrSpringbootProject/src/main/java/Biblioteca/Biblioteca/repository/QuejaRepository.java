package Biblioteca.Biblioteca.repository;

import Biblioteca.Biblioteca.domain.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuejaRepository extends JpaRepository<Queja, Long> {
}