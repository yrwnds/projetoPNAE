package org.example.projetopnae.model.entrega;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    Entrega findById(long id);
}
