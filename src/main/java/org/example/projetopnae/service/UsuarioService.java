package org.example.projetopnae.service;

import org.example.projetopnae.model.usuario.DadosUsuario;
import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.model.usuario.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrar(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        this.usuarioRepository.save(usuario);
    }

    public void save(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    public List<DadosUsuario> findAll() {
        return this.usuarioRepository.findAll().stream().map(DadosUsuario::new).toList();
    }

    public DadosUsuario findById(Long id) {
        Usuario usuario = this.usuarioRepository.findById(id).get();
        return new DadosUsuario(usuario);
    }

    public DadosUsuario findByEmailandSenha(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
        return new DadosUsuario(usuario);
    }

    public DadosUsuario findByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return new DadosUsuario(usuario);
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
