package org.example.mongocrud.model.receita;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.mongocrud.model.ingrediente.Ingrediente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("receitas")
public class Receita {
    @Id
    private String id;
    private Long empresaId;
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