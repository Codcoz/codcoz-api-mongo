package org.example.mongocrud.dto.historico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.mongocrud.model.historico.Message;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class HistoricoChatResponseDTO {
    private String id;
    private String tipo;
    private List<Message> mensagens;
}

/*
por que usar essa classe se ela contem os mesmos campos do Model? Porque, em
eventuais modificações no model (caso seja dados sensíveis, por exemplo), o
que será retornado ao usuário permanecerá a mesma coisa (pois a alteração no
model, em caso incremental, não alterará o ResponseDTO)
*/
