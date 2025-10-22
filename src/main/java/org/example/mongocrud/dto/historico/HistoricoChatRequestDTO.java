package org.example.mongocrud.dto.historico;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.mongocrud.model.historico.Message;
import org.example.mongocrud.validation.OnCreate;
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
    @NotNull(message = "É necessário preencher o campo tipo", groups = OnCreate.class)
    private String tipo;
    @NotNull(message = "É necessário preencher o campo mensagens", groups = OnCreate.class)
    private List<Message> mensagens;
}