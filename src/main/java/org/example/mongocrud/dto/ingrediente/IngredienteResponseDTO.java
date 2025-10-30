package org.example.mongocrud.dto.ingrediente;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class IngredienteResponseDTO {
    private String id;
    private Long empresaId;
    private String categoria;
    private String nome;
    private String descricao;
    private Integer quantidadeMinima;
}
