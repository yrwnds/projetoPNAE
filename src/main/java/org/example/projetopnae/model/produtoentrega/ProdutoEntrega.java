package org.example.projetopnae.model.produtoentrega;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.example.projetopnae.model.agricultor.Agricultor;
import org.example.projetopnae.model.entrega.Entrega;
import org.example.projetopnae.model.tipoalimenticio.TipoAlimenticio;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "produtoentrega")
@Schema(description = "Entidade que representa um produto, parte de uma entrega.")
public class ProdutoEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long qtd;

    private String tipound;

    private String observacao;

    @ManyToOne
    private TipoAlimenticio idtipo;

    @ManyToOne
    @NonNull
    private Entrega identrega;

    @ManyToOne
    private Agricultor idagricultor;
}
