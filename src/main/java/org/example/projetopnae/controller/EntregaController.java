package org.example.projetopnae.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.projetopnae.model.entrega.Entrega;
import org.example.projetopnae.model.produtoentrega.ProdutoEntrega;
import org.example.projetopnae.service.EntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/entrega")
@Tag(name = "Entrega", description = "Path relacionado a operações de entregas.")
public class EntregaController {
    private EntregaService service;

    public EntregaController(EntregaService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<Entrega> listar() {
        return this.service.findAll();
    }

    @GetMapping("/listar/data/asc")
    public List<Entrega> listarDataAsc() {
        return this.service.getDataAsc();
    }

    @GetMapping("/listar/data/desc")
    public List<Entrega> listarDataDesc() {
        return this.service.getDataDesc();
    }

    @GetMapping("/data/{data}")
    public List<Entrega> buscarPorData(@PathVariable Timestamp data) {
        return this.service.findByData(data);
    }

    @GetMapping("/entredata/{start}/{end}")
    public List<Entrega> buscarPorDataEntre(@PathVariable Timestamp start, @PathVariable Timestamp end) {
        return this.service.findByDataBetween(start, end);
    }

    @GetMapping("/id/{id}")
    public Entrega buscarId(@PathVariable Long id) {
        return this.service.getEntrega(id);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity novo(@RequestBody @Valid Entrega entrega, UriComponentsBuilder uriBuilder) {
        this.service.save(entrega);
        URI uri = uriBuilder.path("/entrega/{id}").buildAndExpand(entrega.getId()).toUri();
        return ResponseEntity.created(uri).body(entrega);
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json) {
        System.out.println(json);
    }

    @PutMapping
    public void editar(@RequestBody Entrega Entrega) {
        this.service.update(Entrega);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id) {
        this.service.delete(id);
    }
}
