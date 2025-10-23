package org.example.mongocrud.dto.ingrediente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class IngredienteRequestDTO {
    private String categoria;
    @JsonProperty("empresa_id")
    private String empresaId;
    private String nome;
    private String descricao;
    @JsonProperty("quantidade_minima")
    private Integer quantidadeMinima;
}
