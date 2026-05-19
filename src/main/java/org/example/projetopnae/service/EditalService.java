package org.example.projetopnae.service;

import org.example.projetopnae.model.edital.Edital;
import org.example.projetopnae.model.edital.EditalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EditalService {
    private final EditalRepository EditalRepository;

    public EditalService(EditalRepository EditalRepository) {
        this.EditalRepository = EditalRepository;
    }

    public void save(Edital edital) {
        this.EditalRepository.save(edital);
    }

    public List<Edital> findAll() {
        return this.EditalRepository.findAll();
    }

    public Edital getEdital(Long id) {
        return this.EditalRepository.findById(id).get();
    }

    public List<Edital> buscarEdital(String param){
        return this.EditalRepository.findByNomeContainingIgnoreCaseOrObservacaoContainingIgnoreCase(param, param);
    }

    public void delete(Long id) {
        this.EditalRepository.deleteById(id);
    }

    public void update(Edital edital) {
        Edital t = this.EditalRepository.getReferenceById(edital.getId());
        t.setObservacao(edital.getObservacao());
        t.setNome(edital.getNome());
        this.EditalRepository.save(t);
    }
}
