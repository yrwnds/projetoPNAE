package org.example.projetopnae.model.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    private long id;
    private String nome;
    private String email;
    private String senha;
}
