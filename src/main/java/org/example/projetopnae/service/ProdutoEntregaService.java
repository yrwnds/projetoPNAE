package org.example.projetopnae.service;

import org.example.projetopnae.model.entrega.Entrega;
import org.example.projetopnae.model.entrega.EntregaRepository;
import org.example.projetopnae.model.produtoentrega.ProdutoEntrega;
import org.example.projetopnae.model.produtoentrega.ProdutoEntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoEntregaService {

    private final ProdutoEntregaRepository produtoEntregaRepository;
    private final EntregaRepository entregaRepository;

    public ProdutoEntregaService(ProdutoEntregaRepository ProdutoEntregaRepository, EntregaRepository entregaRepository) {
        this.produtoEntregaRepository = ProdutoEntregaRepository;
        this.entregaRepository = entregaRepository;
    }

    public void save(ProdutoEntrega produtoEntrega, Long entregaId) {
        Entrega entrega = this.entregaRepository.getReferenceById(entregaId);
        produtoEntrega.setEntrega(entrega);
        this.produtoEntregaRepository.save(produtoEntrega);
    }

    public List<ProdutoEntrega> findAll() {
        return this.produtoEntregaRepository.findAll();
    }

    public ProdutoEntrega getProdutoEntrega(Long id) {
        return this.produtoEntregaRepository.findById(id).get();
    }

    public List<ProdutoEntrega> findByAnyParam(String param){
        return this.produtoEntregaRepository.findByAllParams(param);
    }

    public void delete(Long id) {
        this.produtoEntregaRepository.deleteById(id);
    }

    public List<ProdutoEntrega> findByEntrega(Long id){
        return this.produtoEntregaRepository.findByEntregaId(id);
    }

    public void update(ProdutoEntrega ProdutoEntrega) {
        ProdutoEntrega t = this.produtoEntregaRepository.getReferenceById(ProdutoEntrega.getId());
        t.setQtd(ProdutoEntrega.getQtd());
        t.setEntrega(ProdutoEntrega.getEntrega());
        t.setTipo(ProdutoEntrega.getTipo());
        t.setTipound(ProdutoEntrega.getTipound());
        t.setAgricultor(ProdutoEntrega.getAgricultor());
        t.setObservacao(ProdutoEntrega.getObservacao());
        this.produtoEntregaRepository.save(t);
    }
}
