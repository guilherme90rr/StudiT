package br.com.fiap.studit.repository;

import br.com.fiap.studit.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {
    @Query("SELECT u FROM Usuario u WHERE lower(u.nome) LIKE lower(concat('%', :nome, '%')) ORDER BY u.dataNascimento" +
            " ASC")
    Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<Usuario> findAll(Pageable pageable);


    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
