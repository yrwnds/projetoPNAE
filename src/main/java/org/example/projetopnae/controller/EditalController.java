package org.example.projetopnae.controller;

import org.example.projetopnae.model.edital.Edital;
import org.example.projetopnae.service.EditalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edital")
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
