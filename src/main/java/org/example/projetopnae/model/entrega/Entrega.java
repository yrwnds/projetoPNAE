package org.example.projetopnae.model.entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.example.projetopnae.model.edital.Edital;
import org.example.projetopnae.model.usuario.Usuario;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "entrega")
@Schema(description = "Entidade que representa uma entrega já realizada.")

public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private Timestamp data;

    @ManyToOne
    @NonNull
    private Edital idedital;

    @ManyToOne
    @NonNull
    private Usuario criadopor;
}
