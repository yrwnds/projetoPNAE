package org.example.projetopnae.model.tipoalimenticio;

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
@Table(name = "tipoalimento")
@Schema(description = "Entidade que representa um tipo alimentício que pode ser pedido por um edital do PNAE.")
public class TipoAlimenticio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @ManyToOne
    private Usuario usuario;
}
