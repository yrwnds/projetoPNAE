package org.example.projetopnae.model.produtoentrega;

import org.example.projetopnae.model.agricultor.Agricultor;
import org.example.projetopnae.model.entrega.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoEntregaRepository extends JpaRepository<ProdutoEntrega, Long> {

    ProdutoEntrega findById(long id);
    List<ProdutoEntrega> findByIdentrega(Entrega entrega);
    List<ProdutoEntrega> findByIdagricultor(Agricultor agricultor);
}
