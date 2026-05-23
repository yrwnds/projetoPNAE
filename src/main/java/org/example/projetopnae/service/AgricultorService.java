package org.example.projetopnae.service;

import org.example.projetopnae.model.agricultor.Agricultor;
import org.example.projetopnae.model.agricultor.AgricultorRepository;
import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.model.usuario.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AgricultorService {
    private final AgricultorRepository agricultorRepository;
    private final UsuarioRepository usuarioRepository;

    public AgricultorService(AgricultorRepository agricultorRepository, UsuarioRepository usuarioRepository) {
        this.agricultorRepository = agricultorRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void save(Agricultor agricultor) {
        String usuemail = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        Usuario usulogado = this.usuarioRepository.findByEmail(usuemail);
        agricultor.setUsuario(usulogado);
        this.agricultorRepository.save(agricultor);
    }

    public List<Agricultor> findAll() {
        return this.agricultorRepository.findAll();
    }

    public Agricultor getAgricultor(Long id) {
        return this.agricultorRepository.findById(id).get();
    }

    public Agricultor getAgricultorNomeOuContato(String param){
        return this.agricultorRepository.findByNomeContainingIgnoreCaseOrContatoContainingIgnoreCase(param, param);
    }

    public void delete(Long id) {
        this.agricultorRepository.deleteById(id);
    }

    public void update(Agricultor Agricultor) {
        Agricultor t = this.agricultorRepository.getReferenceById(Agricultor.getId());
        t.setNome(Agricultor.getNome());
        t.setContato(Agricultor.getContato());
        this.agricultorRepository.save(t);
    }}
