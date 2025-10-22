package org.example.mongocrud.dto.receita;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.mongocrud.model.receita.IngredienteReceita;
import org.example.mongocrud.model.receita.ModoPreparo;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReceitaResponseDTO {
    private String id;
    private String nome;
    private String descricao;
    private String urlImagem;
    private List<IngredienteReceita> ingredientes;
    private List<ModoPreparo> modoPreparo;
    private Integer tempoPreparoMinutos;
    private Integer tempoCozimentoMinutos;
    private Integer porcoes;
    private LocalDateTime dataCriacao;
}
