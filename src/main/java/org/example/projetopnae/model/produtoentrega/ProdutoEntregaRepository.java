package org.example.projetopnae.model.produtoentrega;

import org.example.projetopnae.model.entrega.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoEntregaRepository extends JpaRepository<ProdutoEntrega, Long> {

    ProdutoEntrega findById(long id);

    List<ProdutoEntrega> findByIdentregaId(Long entregaid);

    @Query("SELECT p FROM ProdutoEntrega p WHERE LOWER(p.observacao) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.tipo.nome)" +
            "LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.agricultor.nome) LIKE (CONCAT('%', :keyword, '%'))")
    List<ProdutoEntrega> findByAllParams(@Param("keyword") String keyword);

}
