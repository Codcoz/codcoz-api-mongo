package org.example.mongocrud.dto.cardapio;

import lombok.*;
import org.example.mongocrud.model.cardapio.CardapioSemanal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CardapioResponseDTO {
    private String id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer empresaId;
    private CardapioSemanal cardapioSemanal;
}