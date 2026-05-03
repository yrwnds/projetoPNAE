package org.example.projetopnae.service;

import org.example.projetopnae.model.entrega.Entrega;
import org.example.projetopnae.model.entrega.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntregaService {
    private final EntregaRepository EntregaRepository;

    public EntregaService(EntregaRepository EntregaRepository) {
        this.EntregaRepository = EntregaRepository;
    }

    public void save(Entrega Entrega) {
        this.EntregaRepository.save(Entrega);
    }

    public List<Entrega> findAll() {
        return this.EntregaRepository.findAll();
    }

    public Entrega getEntrega(Long id) {
        return this.EntregaRepository.findById(id).get();
    }

    public void delete(Long id) {
        this.EntregaRepository.deleteById(id);
    }

    public void update(Entrega Entrega) {
        Entrega t = this.EntregaRepository.getReferenceById(Entrega.getId());
        t.setData(Entrega.getData());
        t.setIdedital(Entrega.getIdedital());
        this.EntregaRepository.save(t);
    }
}
