package br.com.fiap.studit.services;

import br.com.fiap.studit.models.Usuario;
import br.com.fiap.studit.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Page<Usuario> getAllUsuarios(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }
    public Page<Usuario> getAllUsuariosByNomeContainingIgnoreCase(String nome, Pageable pageable) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome,pageable);
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuarioById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> login(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }
}
