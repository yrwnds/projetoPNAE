package org.example.projetopnae.model.tipoalimenticio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoAlimenticioRepository extends JpaRepository<TipoAlimenticio, Long> {

    TipoAlimenticio findById(long id);

    List<TipoAlimenticio> findByNomeContainingIgnoreCase(String keyword);
}
