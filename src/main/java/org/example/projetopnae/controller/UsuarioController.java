package org.example.projetopnae.controller;

import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
