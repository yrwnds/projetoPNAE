package org.example.projetopnae.model.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String nome;

    @NonNull
    @Email
    private String email;

    @NonNull
    private String senha;
}
