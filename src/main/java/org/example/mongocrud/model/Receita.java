package org.example.mongocrud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("receitas")
public class Receita {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private String urlImagem;
    private List<Ingrediente> ingredientes;
    private List<ModoPreparo> modoPreparo;
    private Integer tempoPreparoMinutos;
    private Integer tempoCozimentoMinutos;
    private Integer porcoes;
    private Date dataCriacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<ModoPreparo> getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(List<ModoPreparo> modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public Integer getTempoPreparoMinutos() {
        return tempoPreparoMinutos;
    }

    public void setTempoPreparoMinutos(Integer tempoPreparoMinutos) {
        this.tempoPreparoMinutos = tempoPreparoMinutos;
    }

    public Integer getTempoCozimentoMinutos() {
        return tempoCozimentoMinutos;
    }

    public void setTempoCozimentoMinutos(Integer tempoCozimentoMinutos) {
        this.tempoCozimentoMinutos = tempoCozimentoMinutos;
    }

    public Integer getPorcoes() {
        return porcoes;
    }

    public void setPorcoes(Integer porcoes) {
        this.porcoes = porcoes;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}


/*{
  "_id": "ObjectId()",
  "nome": "Macarrão à Bolonhesa",
  "descricao": "Clássico prato italiano com molho de carne e tomate.",
  "url_image": "https://exemplo.com/imagens/macarrao-bolonhesa.jpg",
  "ingredientes": [
   {
    "ingrediente_id": 1,
    "nome": "Macarrão",
    "unidade_medida": "g",
    "quantidade": 500
   },
   {
    "ingrediente_id": 2,
    "nome": "Carne moída",
    "unidade_medida": "g",
    "quantidade": 500
   },
   {
    "ingrediente_id": 3,
    "nome": "Tomate",
    "unidade_medida": "unid",
    "quantidade": 4
   }
  ],
  "modo_preparo": [
   {
    "ordem": 1,
    "passo": "Pique a cebola e refogue por alguns minutos até dourar."
   },
   {
    "ordem": 2,
    "passo": "Misture a carne moída e cozinhe por alguns minutos."
   },
   {
    "ordem": 3,
    "passo": "Adicione o tomate, sal, pimenta e cozinhe por cerca de 40 minutos."
   },
   {
    "ordem": 4,
    "passo": "Prepare o macarrão, misture ao molho e sirva."
   }
  ],
  "tempo_preparo_minutos": 15,
  "tempo_cozimento_minutos": 30,
  "porcoes": 6,
  "data_criacao": "2025-10-07T00:00:00Z"
}*/