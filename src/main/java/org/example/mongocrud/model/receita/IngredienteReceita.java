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
    @JsonProperty("receita_id")
    private Integer ingredienteId;
    private String nome;
    @JsonProperty("unidade_medida")
    private String unidadeMedida;
    private Integer quantidade;
}
