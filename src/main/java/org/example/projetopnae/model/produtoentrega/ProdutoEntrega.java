package org.example.projetopnae.model.produtoentrega;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private Long id;

    private Long qtd;

    private String tipound;

    private String observacao;

    @ManyToOne
    private TipoAlimenticio idtipo;

    @ManyToOne
    @NotBlank
    private Entrega entrega;

    @ManyToOne
    private Agricultor agricultor;
}
