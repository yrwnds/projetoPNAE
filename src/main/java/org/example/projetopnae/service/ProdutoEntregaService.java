package org.example.projetopnae.service;

import org.example.projetopnae.model.produtoentrega.ProdutoEntrega;
import org.example.projetopnae.model.produtoentrega.ProdutoEntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdutoEntregaService {

    private final ProdutoEntregaRepository produtoEntregaRepository;

    public ProdutoEntregaService(ProdutoEntregaRepository ProdutoEntregaRepository) {
        this.produtoEntregaRepository = ProdutoEntregaRepository;
    }

    public void save(ProdutoEntrega ProdutoEntrega) {
        this.produtoEntregaRepository.save(ProdutoEntrega);
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

    public void update(ProdutoEntrega ProdutoEntrega) {
        ProdutoEntrega t = this.produtoEntregaRepository.getReferenceById(ProdutoEntrega.getId());
        t.setQtd(ProdutoEntrega.getQtd());
        t.setIdentrega(ProdutoEntrega.getIdentrega());
        t.setIdtipo(ProdutoEntrega.getIdtipo());
        t.setTipound(ProdutoEntrega.getTipound());
        t.setIdagricultor(ProdutoEntrega.getIdagricultor());
        t.setObservacao(ProdutoEntrega.getObservacao());
        this.produtoEntregaRepository.save(t);
    }
}
