package org.example.projetopnae.service;

import org.example.projetopnae.model.agricultor.Agricultor;
import org.example.projetopnae.model.agricultor.AgricultorRepository;

import java.util.List;

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

    public void delete(Long id) {
        this.AgricultorRepository.deleteById(id);
    }

    public void update(Agricultor Agricultor) {
        Agricultor t = this.AgricultorRepository.getReferenceById(Agricultor.getId());
        t.setNome(Agricultor.getNome());
        t.setContato(Agricultor.getContato());
        this.AgricultorRepository.save(t);
    }}
