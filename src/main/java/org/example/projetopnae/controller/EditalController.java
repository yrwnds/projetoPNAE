package org.example.projetopnae.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.projetopnae.model.edital.Edital;
import org.example.projetopnae.model.produtoentrega.ProdutoEntrega;
import org.example.projetopnae.service.EditalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/edital")
@Tag(name = "Edital", description = "Path relacionado a operações de edital.")
public class EditalController {
    private EditalService service;
    public EditalController(EditalService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<Edital> listar() {
        return this.service.findAll();
    }

    @GetMapping("/id/{id}")
    public Edital buscarId(@PathVariable Long id) {
        return this.service.getEdital(id);
    }

    @GetMapping("/buscar/{param}")
    @Operation(summary = "Buscar edital por nome ou observação", description = "Retorna um edital se parâmetro incluir parte de seu nome ou observação")
    public List<Edital> buscar(@PathVariable String param) {
        return this.service.buscarEdital(param);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity novo(@RequestBody @Valid Edital edital, UriComponentsBuilder uriBuilder) {
        this.service.save(edital);
        URI uri = uriBuilder.path("/edital/{id}").buildAndExpand(edital.getId()).toUri();
        return ResponseEntity.created(uri).body(edital);
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @PutMapping
    public void editar(@RequestBody Edital Edital){
        this.service.update(Edital);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id){
        this.service.delete(id);
    }
}
