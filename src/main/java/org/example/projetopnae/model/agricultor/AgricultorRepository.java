package org.example.projetopnae.model.agricultor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgricultorRepository extends JpaRepository<Agricultor, Long> {

    Agricultor findById(long id);
    Agricultor findByNomeContainingIgnoreCaseOrContatoContainingIgnoreCase(String nome, String contato);
}
