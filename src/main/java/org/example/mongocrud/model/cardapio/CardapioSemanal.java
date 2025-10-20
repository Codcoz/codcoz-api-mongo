package org.example.mongocrud.model.cardapio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardapioSemanal {
    private CardapioDiario segunda;
    private CardapioDiario terca;
    private CardapioDiario quarta;
    private CardapioDiario quinta;
    private CardapioDiario sexta;
}