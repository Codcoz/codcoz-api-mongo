package org.example.mongocrud.model.cardapio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Almoco {
    private ReceitaAlmoco arrozIntegral;
    private ReceitaAlmoco arroz;
    private ReceitaAlmoco feijao;
    private List<ReceitaAlmocoGrupo> proteinas;
    private ReceitaAlmoco guarnicao;
    private List<ReceitaAlmocoGrupo> saladas;
    private ReceitaAlmoco molhoSalada;
    private ReceitaAlmoco sobremesa;
}