package org.example.projetopnae.model.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
@Schema(description = "Entidade que representa um usuário do sistema de controle de entregas PNAE.")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @NotBlank
    private String nome;

    @NonNull
    @Email
    private String email;

    @NonNull
    @NotBlank
    private String senha;
}
