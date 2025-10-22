package org.example.mongocrud.model.cardapio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReceitaAlmocoGrupo {
    private Integer prioridade;
    private String receitaId;
}
