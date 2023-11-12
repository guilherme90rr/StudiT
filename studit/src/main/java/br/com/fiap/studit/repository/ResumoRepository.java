package br.com.fiap.studit.repository;

import br.com.fiap.studit.models.MateriaEnum;
import br.com.fiap.studit.models.Resumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumoRepository extends JpaRepository<Resumo, Long> {

    @Query("SELECT r FROM Resumo r WHERE LOWER(r.conteudo) LIKE LOWER(concat('%', :conteudo, '%'))")
    Page<Resumo> findByConteudoContainingIgnoreCase(String conteudo, Pageable pageable);

    @Query("SELECT r FROM Resumo r WHERE LOWER(r.conteudo) LIKE LOWER(concat('%', :conteudo, '%')) " +
            "AND r.materiaEnum = :materia")
    Page<Resumo> findByConteudoAndMateria(String conteudo, MateriaEnum materia, Pageable pageable);

    @Query("SELECT r FROM Resumo r WHERE r.materiaEnum = :materia")
    Page<Resumo> findByMateria(MateriaEnum materia, Pageable pageable);

    Page<Resumo> findAll(Pageable pageable);

    Optional<Resumo> findById(Long id);
}
