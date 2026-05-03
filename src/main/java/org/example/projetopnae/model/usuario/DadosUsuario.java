package org.example.projetopnae.model.usuario;

public record DadosUsuario(Long id, String email, String nome, String senha) {
    public DadosUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getEmail(), usuario.getNome(), usuario.getSenha());
    }
}
