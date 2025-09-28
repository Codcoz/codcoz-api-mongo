package org.example.mongocrud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("testCollection")
public class HistoricoChat {
    @Id
    private String id;
    private String tipo;
    private List<Message> mensagens;

    public HistoricoChat(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Message> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Message> mensagens) {
        this.mensagens = mensagens;
    }
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