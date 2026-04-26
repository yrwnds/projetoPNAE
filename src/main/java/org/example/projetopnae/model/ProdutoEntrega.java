package org.example.projetopnae.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoEntrega {
    private long id;
    private long qtd;
    private String tipound;
    private String observacao;
    private TipoAlimenticio idtipo;
    private Entrega identrega;
    private Agricultor idagricultor;
}
