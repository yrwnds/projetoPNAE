package org.example.projetopnae.model.edital;

import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditalRepository extends JpaRepository<Edital, Long> {

    Edital findById(long id);
    List<Edital> findByNomeOrObservacaoContainingIgnoreCase(String nome, String observacao);
}
