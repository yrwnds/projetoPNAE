package org.example.projetopnae.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.projetopnae.model.produtoentrega.ProdutoEntrega;
import org.example.projetopnae.service.ProdutoEntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtoentrega")
public class ProdutoEntregaController {
    private ProdutoEntregaService service;
    public ProdutoEntregaController(ProdutoEntregaService service) {
        this.service = service;
    }
    
    @GetMapping("/listar")
    public List<ProdutoEntrega> listar() {
        return this.service.findAll();
    }

    @PostMapping()
    @Transactional
    public ResponseEntity novo(@RequestBody @Valid ProdutoEntrega produtoEntrega, UriComponentsBuilder uriBuilder) {
        this.service.save(produtoEntrega);
        URI uri = uriBuilder.path("/produtoentrega/{id}").buildAndExpand(produtoEntrega.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoEntrega);
    }

    @GetMapping("/buscar/{param}")
    public List<ProdutoEntrega> buscar(@PathVariable String param) {
        return this.service.findByAnyParam(param);
    }

    @GetMapping("/id/{id}")
    public ProdutoEntrega buscarId(@PathVariable Long id) {
        return this.service.getProdutoEntrega(id);
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @PutMapping
    public void editar(@RequestBody ProdutoEntrega produtoEntrega){
        this.service.update(produtoEntrega);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id){
        this.service.delete(id);
    }
}
