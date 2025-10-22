package org.example.mongocrud.model.cardapio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Opcao {
    private Integer prioridade;
    @JsonProperty("receita_id")
    private String receitaId;
    @JsonProperty("ingrediente_id")
    private String ingredienteId;
}