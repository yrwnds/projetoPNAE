package org.example.projetopnae.service;

import org.example.projetopnae.model.agricultor.Agricultor;
import org.example.projetopnae.model.agricultor.AgricultorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgricultorService {
    private final org.example.projetopnae.model.agricultor.AgricultorRepository AgricultorRepository;

    public AgricultorService(AgricultorRepository AgricultorRepository) {
        this.AgricultorRepository = AgricultorRepository;
    }

    public void save(Agricultor Agricultor) {
        this.AgricultorRepository.save(Agricultor);
    }

    public List<Agricultor> findAll() {
        return this.AgricultorRepository.findAll();
    }

    public Agricultor getAgricultor(Long id) {
        return this.AgricultorRepository.findById(id).get();
    }

    public Agricultor getAgricultorNomeOuContato(String param){
        return this.AgricultorRepository.findByNomeContainingIgnoreCaseOrContatoContainingIgnoreCase(param, param);
    }

    public void delete(Long id) {
        this.AgricultorRepository.deleteById(id);
    }

    public void update(Agricultor Agricultor) {
        Agricultor t = this.AgricultorRepository.getReferenceById(Agricultor.getId());
        t.setNome(Agricultor.getNome());
        t.setContato(Agricultor.getContato());
        this.AgricultorRepository.save(t);
    }}
