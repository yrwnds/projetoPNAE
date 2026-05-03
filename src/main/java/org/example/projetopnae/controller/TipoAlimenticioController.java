package org.example.projetopnae.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticio;
import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.service.TipoAlimenticioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tipoalimenticio")
public class TipoAlimenticioController {
    private TipoAlimenticioService service;
    public TipoAlimenticioController(TipoAlimenticioService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<TipoAlimenticio> listaTipoAlimenticio() {
        return this.service.findAll();
    }

    @GetMapping("/nome/{nome}")
    public List<TipoAlimenticio> buscarTipoAlimenticio(@PathVariable String nome) {
        return this.service.getTipoAlimenticioNome(nome);
    }

    @GetMapping("/id/{id}")
    public TipoAlimenticio buscarTipoAlimenticio(@PathVariable long id) {
        return this.service.getTipoAlimenticioId(id);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity novo(@RequestBody @Valid TipoAlimenticio tipoAlimenticio, UriComponentsBuilder uriBuilder) {
        this.service.save(tipoAlimenticio);
        URI uri = uriBuilder.path("/tipoalimenticio/{id}").buildAndExpand(tipoAlimenticio.getId()).toUri();
        return ResponseEntity.created(uri).body(tipoAlimenticio);
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @PutMapping
    public void editar(@RequestBody TipoAlimenticio tipoAlimenticio){
        this.service.update(tipoAlimenticio);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id){
        this.service.delete(id);
    }
}
