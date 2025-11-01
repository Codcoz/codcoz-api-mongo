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
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long empresaId;
    private List<CardapioDiario> dias;
}