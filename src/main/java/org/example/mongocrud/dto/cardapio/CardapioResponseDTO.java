package org.example.mongocrud.dto.cardapio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.mongocrud.model.cardapio.CardapioDiario;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CardapioResponseDTO {
    private String id;
    @JsonProperty("data_inicio")
    private LocalDate dataInicio;
    @JsonProperty("data_fim")
    private LocalDate dataFim;
    @JsonProperty("empresa_id")
    private Long empresaId;
    @JsonProperty("cardapio_semanal")
    private List<CardapioDiario> dias;
}