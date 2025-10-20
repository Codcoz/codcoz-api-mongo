package org.example.mongocrud.dto.cardapio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.mongocrud.model.cardapio.CardapioSemanal;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "cardapios")
public class CardapioRequestDTO {
    @JsonProperty("data_inicio")
    private LocalDate dataInicio;
    @JsonProperty("data_fim")
    private LocalDate dataFim;
    @JsonProperty("empresa_id")
    private Integer empresaId;
    @JsonProperty("cardapio_semanal")
    private CardapioSemanal cardapioSemanal;
}