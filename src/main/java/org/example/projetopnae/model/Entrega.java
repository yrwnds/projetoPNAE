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
public class Entrega {
    private long id;
    private Timestamp data;
    private Edital idedital;
    private Usuario criadopor;
}
