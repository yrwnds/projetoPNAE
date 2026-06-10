package org.example.projetopnae.service;

import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticio;
import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticioRepository;
import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.model.usuario.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TipoAlimenticioService {
    private final TipoAlimenticioRepository tipoAlimenticioRepository;
    private final UsuarioRepository usuarioRepository;

    public TipoAlimenticioService(TipoAlimenticioRepository tipoAlimenticioRepository, UsuarioRepository usuarioRepository) {
        this.tipoAlimenticioRepository = tipoAlimenticioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void save(TipoAlimenticio tipoAlimenticio) {
        String usuemail = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        Usuario usulogado = this.usuarioRepository.findByEmail(usuemail);
        tipoAlimenticio.setUsuario(usulogado);
        tipoAlimenticio.setNome(tipoAlimenticio.getNome().toUpperCase());
        this.tipoAlimenticioRepository.save(tipoAlimenticio);
    }

    public List<TipoAlimenticio> findAll() {
        return this.tipoAlimenticioRepository.findAllByOrderByNomeAsc();
    }

    public TipoAlimenticio getTipoAlimenticioId(Long id) {
        return this.tipoAlimenticioRepository.findById(id).get();
    }

    public List<TipoAlimenticio> getTipoAlimenticioNome(String nome) {
        return this.tipoAlimenticioRepository.findByNomeContainingIgnoreCase(nome);
    }

    public void delete(Long id) {
        this.tipoAlimenticioRepository.deleteById(id);
    }

    public void update(TipoAlimenticio tipoAlimenticio) {
        TipoAlimenticio t = this.tipoAlimenticioRepository.getReferenceById(tipoAlimenticio.getId());
        t.setNome(tipoAlimenticio.getNome());
        this.tipoAlimenticioRepository.save(t);
    }
}
