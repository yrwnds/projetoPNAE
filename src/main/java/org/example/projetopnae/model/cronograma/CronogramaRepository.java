package org.example.projetopnae.model.cronograma;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CronogramaRepository extends JpaRepository<Cronograma, Long> {

    Cronograma findById(long id);
}
