package org.example.projetopnae.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cronograma {
    private long id;
    private long qtd;
    private String tipound;
    private String observacao;
    private Timestamp previsaoentrega;
    private TipoAlimenticio idtipo;
}
