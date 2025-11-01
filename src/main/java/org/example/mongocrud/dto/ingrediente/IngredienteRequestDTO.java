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
    private Long empresaId;
    private String nome;
    private String descricao;
    private Integer quantidadeMinima;
}
