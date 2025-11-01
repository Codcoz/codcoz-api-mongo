package org.example.mongocrud.model.receita;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
public class IngredienteReceita {
    private Integer receitaId;
    private String nome;
    private String unidadeMedida;
    private Integer quantidade;
}
