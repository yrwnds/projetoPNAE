package org.example.projetopnae.model.edital;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Edital {
    private long id;
    private String observacao;
    private String nome;
}
