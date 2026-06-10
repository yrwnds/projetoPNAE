package org.example.projetopnae.service;

import org.example.projetopnae.model.edital.Edital;
import org.example.projetopnae.model.edital.EditalRepository;
import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.model.usuario.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EditalService {
    private final EditalRepository editalRepository;
    private final UsuarioRepository usuarioRepository;

    public EditalService(EditalRepository editalRepository, UsuarioRepository usuarioRepository) {
        this.editalRepository = editalRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void save(Edital edital) {
        String usuemail = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        Usuario usulogado = this.usuarioRepository.findByEmail(usuemail);
        edital.setUsuario(usulogado);
        edital.setNome(edital.getNome().toUpperCase());
        this.editalRepository.save(edital);
    }

    public List<Edital> findAll() {
        return this.editalRepository.findAll();
    }

    public Edital getEdital(Long id) {
        return this.editalRepository.findById(id).get();
    }

    public List<Edital> buscarEdital(String param){
        return this.editalRepository.findByNomeContainingIgnoreCaseOrObservacaoContainingIgnoreCase(param, param);
    }

    public void delete(Long id) {
        this.editalRepository.deleteById(id);
    }

    public void update(Edital edital) {
        Edital t = this.editalRepository.getReferenceById(edital.getId());
        t.setObservacao(edital.getObservacao());
        t.setNome(edital.getNome());
        this.editalRepository.save(t);
    }
}
