package org.example.mongocrud.dto.receita;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ReceitaRequestDTO {
    private String nome;
    @JsonProperty("empresa_id")
    private String empresaId;
    private String descricao;
    @JsonProperty("url_imagem")
    private String urlImagem;
    private List<IngredienteReceita> ingredientes;
    @JsonProperty("modo_preparo")
    private List<ModoPreparo> modoPreparo;
    @JsonProperty("tempo_preparo_minutos")
    private Integer tempoPreparoMinutos;
    @JsonProperty("tempo_cozimento_minutos")
    private Integer tempoCozimentoMinutos;
    private Integer porcoes;
    @JsonProperty("data_criacao")
    private LocalDateTime dataCriacao;
}
