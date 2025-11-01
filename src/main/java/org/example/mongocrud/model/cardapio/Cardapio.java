package org.example.mongocrud.model.cardapio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "cardapios")
public class Cardapio {
    @Id
    private String id;
    private String nomeCardapio;
    private String periodicidade;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long empresaId;
    private List<CardapioDiario> dias;
}