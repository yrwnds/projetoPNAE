package org.example.projetopnae.controller;

import org.example.projetopnae.model.agricultor.Agricultor;
import org.example.projetopnae.service.AgricultorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agricultor")
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
