package org.example.mongocrud.dto.historico;

import lombok.*;
import org.example.mongocrud.model.historico.Message;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "historicoChat")
public class HistoricoChatRequestDTO {
    private String tipo;
    private List<Message> mensagens;
}