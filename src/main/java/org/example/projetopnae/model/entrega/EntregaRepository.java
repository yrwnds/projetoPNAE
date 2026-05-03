package org.example.projetopnae.model.entrega;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    Entrega findById(long id);
    List<Entrega> findByDataBetween(Timestamp start, Timestamp end);
    List<Entrega> findByData(Timestamp data);

    List<Entrega> findAllByOrderByDataAsc();
    List<Entrega> findAllByOrderByDataDesc();
}
