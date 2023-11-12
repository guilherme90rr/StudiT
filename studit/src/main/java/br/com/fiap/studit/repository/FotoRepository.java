package br.com.fiap.studit.repository;

import br.com.fiap.studit.models.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FotoRepository extends JpaRepository<Foto, Long> {
    List<Foto> findAll();

    Optional<Foto> findById(Long id);
}
