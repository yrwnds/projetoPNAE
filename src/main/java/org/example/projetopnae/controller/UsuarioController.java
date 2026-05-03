package org.example.projetopnae.controller;

import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<Usuario> listar(){
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable long id){
        return this.service.findById(id);
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @PostMapping()
    public void salvar(@RequestBody Usuario usuario){
        this.service.save(usuario);
    }

    @PutMapping
    public void editar(@RequestBody Usuario usuario){
        this.service.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id){
        this.service.delete(id);
    }
}
