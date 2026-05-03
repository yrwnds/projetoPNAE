package org.example.projetopnae.model.tipoalimenticio;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

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
    private long id;

    @NonNull
    private String nome;
}
