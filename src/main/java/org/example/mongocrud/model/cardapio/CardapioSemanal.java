package org.example.mongocrud.model.cardapio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardapioSemanal {
    private String diaSemana;
    private LocalDate data;
    private Lanche lancheManha; //optei por criar uma classe Lanche para ser mais extensível
    private Almoco almoco;
    private Lanche lancheTarde;
}