package org.example.projetopnae.model.cronograma;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
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
    private long id;

    private long qtd;

    private String tipound;

    private String observacao;

    @NonNull
    private Timestamp previsaoentrega;

    @ManyToOne
    private TipoAlimenticio idtipo;
}
