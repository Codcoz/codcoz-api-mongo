package org.example.mongocrud.model.empresa;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "empresas")
public class Empresa {
    @Id
    private String id;
    private String nome;
    private String sigla;
    private String status;
}
