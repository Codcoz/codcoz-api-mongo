package org.example.mongocrud.dto.cardapio;

import lombok.*;
import org.example.mongocrud.model.cardapio.CardapioSemanal;

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
    private String periodicidade;
    private String nomeCardapio;
    private Long empresaId;
    private List<CardapioSemanal> cardapioSemanal;
}