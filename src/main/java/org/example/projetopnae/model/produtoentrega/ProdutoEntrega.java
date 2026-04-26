package org.example.projetopnae.model.produtoentrega;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.projetopnae.model.agricultor.Agricultor;
import org.example.projetopnae.model.entrega.Entrega;
import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticio;

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
