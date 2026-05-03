package org.example.projetopnae.model.edital;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "edital")
public class Edital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String observacao;

    @NonNull
    private String nome;
}
