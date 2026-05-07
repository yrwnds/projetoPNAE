package org.example.projetopnae.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.projetopnae.model.cronograma.Cronograma;
import org.example.projetopnae.service.CronogramaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/cronograma")
@Tag(name = "Cronograma", description = "Path relacionado a operações de cronograma.")
public class CronogramaController {
    private CronogramaService service;
    public CronogramaController(CronogramaService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<Cronograma> listar() {
        return this.service.findAll();
    }

    @GetMapping("/id/{id}")
    public Cronograma buscarId(@PathVariable Long id) {
        return this.service.getCronograma(id);
    }

    @GetMapping("/buscar/{param}")
    @Operation(summary = "Buscar cronograma por observação", description = "Retorna um cronograma se parâmetro incluir parte da observação")
    public List<Cronograma> buscarParam(@PathVariable String param) {
        return this.service.getCronogramaByObservacao(param);
    }

    @GetMapping("/data/{data}")
    @Operation(summary = "Buscar agricultor por data de previsão de entrega", description = "Retorna crono. se sua previsão de entrega é para determinada data")
    public List<Cronograma> buscarData(@PathVariable Timestamp data) {
        return this.service.getCronogramaByDate(data);
    }

    @GetMapping("/databetween/{start}/{end}")
    @Operation(summary = "Buscar cronograma por período", description = "Retorna um crono. se estiver entre data 1 e data 2")
    public List<Cronograma> buscarDataBetween(@PathVariable Timestamp start, @PathVariable Timestamp end) {
        return this.service.getCronogramaByDatePeriod(start, end);
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity novo(@RequestBody @Valid Cronograma cronograma, UriComponentsBuilder uriBuilder) {
        this.service.save(cronograma);
        URI uri = uriBuilder.path("/cronograma/{id}").buildAndExpand(cronograma.getId()).toUri();
        return ResponseEntity.created(uri).body(cronograma);
    }

    @PutMapping
    public void editar(@RequestBody Cronograma Cronograma){
        this.service.update(Cronograma);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id){
        this.service.delete(id);
    }
}
