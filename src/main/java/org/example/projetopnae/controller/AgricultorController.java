package org.example.projetopnae.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.projetopnae.model.agricultor.Agricultor;
import org.example.projetopnae.service.AgricultorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/agricultor")
@Tag(name = "Agricultor", description = "Path relacionado a operações de agricultores.")
public class AgricultorController {
    private AgricultorService service;
    public AgricultorController(AgricultorService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<Agricultor> listar() {
        return this.service.findAll();
    }

    @GetMapping("/id/{id}")
    public Agricultor buscarId(@PathVariable Long id) {
        return this.service.getAgricultor(id);
    }

    @GetMapping("/buscar/{param}")
    @Operation(summary = "Buscar agricultor por nome ou informação de contato", description = "Retorna um agricultor se parâmetro incluir parte de seu nome ou informação de contato")
    public Agricultor buscarAnyParam(@PathVariable String param) {
        return this.service.getAgricultorNomeOuContato(param);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity novo(@RequestBody @Valid Agricultor agricultor, UriComponentsBuilder uriBuilder) {
        this.service.save(agricultor);
        URI uri = uriBuilder.path("/agricultor/{id}").buildAndExpand(agricultor.getId()).toUri();
        return ResponseEntity.created(uri).body(agricultor);
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @PutMapping
    public void editar(@RequestBody Agricultor Agricultor){
        this.service.update(Agricultor);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id){
        this.service.delete(id);
    }
}
