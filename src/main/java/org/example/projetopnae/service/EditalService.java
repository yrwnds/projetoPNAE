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

    public void save(Edital Edital) {
        this.EditalRepository.save(Edital);
    }

    public List<Edital> findAll() {
        return this.EditalRepository.findAll();
    }

    public Edital getEdital(Long id) {
        return this.EditalRepository.findById(id).get();
    }

    public void delete(Long id) {
        this.EditalRepository.deleteById(id);
    }

    public void update(Edital Edital) {
        Edital t = this.EditalRepository.getReferenceById(Edital.getId());

        this.EditalRepository.save(t);
    }
}
