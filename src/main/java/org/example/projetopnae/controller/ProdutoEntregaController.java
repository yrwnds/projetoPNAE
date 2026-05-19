package org.example.projetopnae.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "ProdutoEntrega", description = "Path relacionado a operações de produtos entregues.")
public class ProdutoEntregaController {
    private ProdutoEntregaService service;
    public ProdutoEntregaController(ProdutoEntregaService service) {
        this.service = service;
    }
    
    @GetMapping("/listar")
    public List<ProdutoEntrega> listar() {
        return this.service.findAll();
    }

    @PostMapping("/{entregaid}")
    @Transactional
    public ResponseEntity novo(@RequestBody @Valid ProdutoEntrega produtoEntrega, @PathVariable Long entregaid, UriComponentsBuilder uriBuilder) {
        this.service.save(produtoEntrega, entregaid);
        URI uri = uriBuilder.path("/produtoentrega/{id}").buildAndExpand(produtoEntrega.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoEntrega);
    }

    @GetMapping("/buscar/{param}")
    @Operation(summary = "Busca produtos por alimentos, agricultor, observação.", description = "Retorna produtos se parâmetro incluir informação sobre alimento, agricultor ou observação do produto entregue.")
    public List<ProdutoEntrega> buscar(@PathVariable String param) {
        return this.service.findByAnyParam(param);
    }

    @GetMapping("/identrega/{identrega}")
    public List<ProdutoEntrega> identrega(@PathVariable Long identrega) {
        return this.service.findByEntrega(identrega);
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
