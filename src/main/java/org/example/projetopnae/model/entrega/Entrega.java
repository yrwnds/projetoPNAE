package org.example.projetopnae.model.entrega;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.projetopnae.model.edital.Edital;
import org.example.projetopnae.model.usuario.Usuario;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entrega {
    private long id;
    private Timestamp data;
    private Edital idedital;
    private Usuario criadopor;
}
