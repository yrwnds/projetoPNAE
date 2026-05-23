package org.example.projetopnae.model.edital;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.projetopnae.model.usuario.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "edital")
@Schema(description = "Entidade que representa um edital de requerimento de produtos alimentícios do PNAE.")
public class Edital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacao;

    @NonNull
    private String nome;

    @ManyToOne
    private Usuario usuario;
}
