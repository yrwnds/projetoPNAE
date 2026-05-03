package org.example.projetopnae.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.projetopnae.model.usuario.DadosUsuario;
import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "Path relacionado a operações de usuários.")
public class UsuarioController {

    private UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<DadosUsuario> listar(){
        return this.service.findAll();
    }

    @PostMapping()
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder) {
        this.service.cadastrar(usuario);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @GetMapping("/id/{id}")
    public DadosUsuario buscar(@PathVariable long id){
        return this.service.findById(id);
    }

    @GetMapping("/email/{email}")
    public DadosUsuario buscarPorEmail(@PathVariable String email){
        return this.service.findByEmail(email);
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
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
