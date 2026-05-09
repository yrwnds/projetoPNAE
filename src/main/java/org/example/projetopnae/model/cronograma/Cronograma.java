package org.example.projetopnae.model.cronograma;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticio;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cronograma")
@Schema(description = "Entidade que representa uma entrega que ainda deve ser realizada.")

public class Cronograma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long qtd;

    private String tipound;

    private String observacao;

    @NonNull
    private Timestamp previsaoentrega;

    @ManyToOne
    private TipoAlimenticio tipo;
}
