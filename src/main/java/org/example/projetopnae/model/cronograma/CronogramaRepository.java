package org.example.projetopnae.model.cronograma;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface CronogramaRepository extends JpaRepository<Cronograma, Long> {

    Cronograma findById(long id);
    List<Cronograma> findByPrevisaoentregaBetween(Timestamp start, Timestamp end);
    List<Cronograma> findByPrevisaoentrega(Timestamp previsao);
    List<Cronograma> findByObservacaoContainingIgnoreCase(String observacao);
}
