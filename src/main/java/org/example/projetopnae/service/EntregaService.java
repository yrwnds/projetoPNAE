package org.example.projetopnae.service;

import org.example.projetopnae.model.entrega.Entrega;
import org.example.projetopnae.model.entrega.EntregaRepository;
import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.model.usuario.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class EntregaService {
    private final EntregaRepository EntregaRepository;
    private final UsuarioRepository usuarioRepository;

    public EntregaService(EntregaRepository EntregaRepository, UsuarioRepository usuarioRepository) {
        this.EntregaRepository = EntregaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void save(Entrega entrega) {
        String usuemail = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        Usuario usulogado = this.usuarioRepository.findByEmail(usuemail);
        entrega.setUsuario(usulogado);
        this.EntregaRepository.save(entrega);
    }

    public List<Entrega> findAll() {
        return this.EntregaRepository.findAll();
    }

    public Entrega getEntrega(Long id) {
        return this.EntregaRepository.findById(id).get();
    }

    public List<Entrega> getDataAsc(){
        return this.EntregaRepository.findAllByOrderByDataentregaAsc();
    }

    public List<Entrega> getDataDesc(){
        return this.EntregaRepository.findAllByOrderByDataentregaDesc();
    }

    public List<Entrega> findByData(Timestamp data){
        return this.EntregaRepository.findByDataentrega(data);
    }

    public List<Entrega> findByDataBetween(Timestamp start, Timestamp end){
        return this.EntregaRepository.findByDataentregaBetween(start, end);
    }

    public void delete(Long id) {
        this.EntregaRepository.deleteById(id);
    }

    public void update(Entrega entrega) {
        Entrega t = this.EntregaRepository.getReferenceById(entrega.getId());
        t.setDataentrega(entrega.getDataentrega());
        t.setEdital(entrega.getEdital());
        this.EntregaRepository.save(t);
    }
}
