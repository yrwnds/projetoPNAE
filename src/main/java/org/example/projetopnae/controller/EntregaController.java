package org.example.projetopnae.controller;

import org.example.projetopnae.model.entrega.Entrega;
import org.example.projetopnae.service.EntregaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
    private EntregaService service;
    public EntregaController(EntregaService service) {
        this.service = service;
    }
    
    @GetMapping("/listar")
    public List<Entrega> listar() {
        return this.service.findAll();
    }

    @GetMapping("/id/{id}")
    public Entrega buscarId(@PathVariable Long id) {
        return this.service.getEntrega(id);
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @PutMapping
    public void editar(@RequestBody Entrega Entrega){
        this.service.update(Entrega);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id){
        this.service.delete(id);
    }
}
