package org.example.projetopnae.model.edital;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

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
    private long id;

    private String observacao;

    @NonNull
    private String nome;
}
