package org.example.projetopnae.service;

import org.example.projetopnae.model.cronograma.Cronograma;
import org.example.projetopnae.model.cronograma.CronogramaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    public List<Cronograma> getCronogramaByObservacao(String param) {
        return this.cronogramaRepository.findByObservacaoContainingIgnoreCase(param);
    }

    public List<Cronograma> getCronogramaByDate(Timestamp date){
        return this.cronogramaRepository.findByPrevisaoentrega(date);
    }

    public List<Cronograma> getCronogramaByDatePeriod(Timestamp start, Timestamp end){
        return this.cronogramaRepository.findByPrevisaoentregaBetween(start, end);
    }

    public void delete(Long id) {
        this.cronogramaRepository.deleteById(id);
    }

    public void update(Cronograma Cronograma) {
        Cronograma t = this.cronogramaRepository.getReferenceById(Cronograma.getId());
        t.setQtd(Cronograma.getQtd());
        t.setId(Cronograma.getId());
        t.setTipound(Cronograma.getTipound());
        t.setObservacao(Cronograma.getObservacao());
        t.setPrevisaoentrega(Cronograma.getPrevisaoentrega());
        this.cronogramaRepository.save(t);
    }
}
