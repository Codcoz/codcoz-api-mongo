package org.example.mongocrud.model.historico;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "historicoChat")
public class HistoricoChat {
    @Id
    private String id;
    private String tipo;
    private List<Message> mensagens;
}