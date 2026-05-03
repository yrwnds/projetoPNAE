package org.example.projetopnae.service;

import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticio;
import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoAlimenticioService {
    private final TipoAlimenticioRepository tipoAlimenticioRepository;

    public TipoAlimenticioService(TipoAlimenticioRepository tipoAlimenticioRepository) {
        this.tipoAlimenticioRepository = tipoAlimenticioRepository;
    }

    public void save(TipoAlimenticio tipoAlimenticio) {
        this.tipoAlimenticioRepository.save(tipoAlimenticio);
    }

    public List<TipoAlimenticio> findAll() {
        return this.tipoAlimenticioRepository.findAll();
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
