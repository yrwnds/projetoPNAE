package org.example.projetopnae.controller;

import jakarta.transaction.Transactional;
import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody Usuario usuario, UriComponentsBuilder uriBuilder) {
        this.service.save(usuario);
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @GetMapping("/id/{id}")
    public Usuario buscar(@PathVariable long id){
        return this.service.findById(id);
    }

    @GetMapping("{/email/email}")
    public Usuario buscarPorEmail(@PathVariable String email){
        return this.service.findByEmail(email);
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
