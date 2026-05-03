package org.example.projetopnae.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.projetopnae.model.cronograma.Cronograma;
import org.example.projetopnae.service.CronogramaService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
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
