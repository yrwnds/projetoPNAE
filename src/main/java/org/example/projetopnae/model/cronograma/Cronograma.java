package org.example.projetopnae.model.cronograma;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticio;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cronograma")
public class Cronograma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long qtd;
    private String tipound;
    private String observacao;
    private Timestamp previsaoentrega;
    private TipoAlimenticio idtipo;
}
