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


/*

History Collection

_id: 507f1f77bcf86cd799439011,
type:"App",
messages:[
    {
        index:0,
        message: "Olá",
        date: 11-09-2001,
        from: "user"
    },
    {
        index:1,
        message:"Olá, como posso ajudar?",
        date: 11-09-2002,
        from: "IA"
    }
]
*/