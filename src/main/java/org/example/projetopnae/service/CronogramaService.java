package org.example.projetopnae.service;

import org.example.projetopnae.model.cronograma.Cronograma;
import org.example.projetopnae.model.cronograma.CronogramaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CronogramaService {
    private final CronogramaRepository cronogramaRepository;

    public CronogramaService(CronogramaRepository CronogramaRepository) {
        this.cronogramaRepository = CronogramaRepository;
    }

    public void save(Cronograma Cronograma) {
        this.cronogramaRepository.save(Cronograma);
    }

    public List<Cronograma> findAll() {
        return this.cronogramaRepository.findAll();
    }

    public Cronograma getCronograma(Long id) {
        return this.cronogramaRepository.findById(id).get();
    }

    public void delete(Long id) {
        this.cronogramaRepository.deleteById(id);
    }

    public void update(Cronograma Cronograma) {
        Cronograma t = this.cronogramaRepository.getReferenceById(Cronograma.getId());
        t.setQtd(Cronograma.getQtd());
        t.setIdtipo(Cronograma.getIdtipo());
        t.setTipound(Cronograma.getTipound());
        t.setObservacao(Cronograma.getObservacao());
        t.setPrevisaoentrega(Cronograma.getPrevisaoentrega());
        this.cronogramaRepository.save(t);
    }
}
