package org.example.mongocrud.model.cardapio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardapioDiario {
    @JsonProperty("lanche_manha")
    private List<Lanche> lancheManha; //optei por criar uma classe Lanche para ser mais extensível
    private List<Lanche> almoco;
    @JsonProperty("lanche_tarde")
    private List<Lanche> lancheTarde;
}