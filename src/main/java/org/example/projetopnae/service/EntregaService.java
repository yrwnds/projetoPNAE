package org.example.projetopnae.service;

import org.example.projetopnae.model.entrega.Entrega;
import org.example.projetopnae.model.entrega.EntregaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    public List<Entrega> getDataAsc(){
        return this.EntregaRepository.findAllByOrderByDataAsc();
    }

    public List<Entrega> getDataDesc(){
        return this.EntregaRepository.findAllByOrderByDataDesc();
    }

    public List<Entrega> findByData(Timestamp data){
        return this.EntregaRepository.findByData(data);
    }

    public List<Entrega> findByDataBetween(Timestamp start, Timestamp end){
        return this.EntregaRepository.findByDataBetween(start, end);
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
