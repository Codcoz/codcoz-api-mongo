package org.example.mongocrud.model.ingrediente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("ingredientes")
public class Ingrediente {
    @Id
    private String id;
    private Long empresaId;
    private String categoria;
    private String nome;
    private String descricao;
    private Integer quantidadeMinima;
}