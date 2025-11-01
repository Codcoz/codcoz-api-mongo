package org.example.mongocrud.dto.cardapio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.mongocrud.model.cardapio.CardapioDiario;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "cardapios")
public class CardapioRequestDTO {
    private String nomeCardapio;
    private String periodicidade;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long empresaId;
    private List<CardapioDiario> dias;
}