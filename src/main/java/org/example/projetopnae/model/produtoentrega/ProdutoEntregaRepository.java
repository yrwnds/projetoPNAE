package org.example.projetopnae.model.produtoentrega;

import org.example.projetopnae.model.entrega.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoEntregaRepository extends JpaRepository<ProdutoEntrega, Long> {

    ProdutoEntrega findById(long id);
    List<ProdutoEntrega> findByIdentrega(Entrega entrega);
    List<ProdutoEntrega> findByIdagricultorNomeContainingIgnoreCase(String agricultorNome);
    List<ProdutoEntrega> findByIdtipoNomeContainingIgnoreCase(String tipoAlimenticioNome);
    List<ProdutoEntrega> findByObservacaoContainingIgnoreCase(String observacao);

    @Query("SELECT p FROM ProdutoEntrega p WHERE LOWER(p.observacao) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.idtipo.nome)" +
            "LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.idagricultor.nome) LIKE (CONCAT('%', :keyword, '%'))")
    List<ProdutoEntrega> findByAllParams(@Param("keyword") String keyword);

}
