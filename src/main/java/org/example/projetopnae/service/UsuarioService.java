package org.example.projetopnae.service;

import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.model.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void save(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).get();
    }

    public Usuario findByEmailandSenha(String email, String senha) {
        return this.usuarioRepository.findByEmailAndSenha(email, senha);
    }

    public Usuario findByEmail(String email) {
        return this.usuarioRepository.findByEmail(email);
    }

    public void delete(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    public void update(Usuario usuario) {
        Usuario u = this.usuarioRepository.getReferenceById(usuario.getId());
        u.setEmail(usuario.getEmail());
        u.setSenha(usuario.getSenha());
        u.setNome(usuario.getNome());
        this.usuarioRepository.save(u);
    }
}
