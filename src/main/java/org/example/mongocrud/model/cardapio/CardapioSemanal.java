package org.example.mongocrud.model.cardapio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardapioSemanal {
    private CardapioDiario segunda;
    private CardapioDiario terca;
    private CardapioDiario quarta;
    private CardapioDiario quinta;
    private CardapioDiario sexta;
}


/*{
  "_id": "ObjectId()",
  "data_inicio": "2025-10-06",
  "data_fim": "2025-10-10",
  "empresa_id": 22,
  "cardapio": {
    "segunda": {
      "lanche_manha": [
        { "receita_id": 111},
      ],
      "almoco": [
        { "receita_id": 111 },
        { "receita_id": 111 },
        { "receita_id": 111 }
      ],
      "lanche_tarde": [
        { "receita_id": 111 },
        { "receita_id": 111 }
      ]
    },
    "terca": {
      "lanche_manha": [
        { "receita_id": 1 },
        { "receita_id": 1 },
        { "receita_id": 1 }
      ],
      "almoco": [
        { "receita_id": 1 },
        { "receita_id": 1 },
        { "receita_id": 1 }
      ],
      "lanche_tarde": [
        { "receita_id": 1 }
      ]
    },
    "quarta": {
      "lanche_manha": [
        { "receita_id": 1 },
        { "receita_id": 1 },
        { "receita_id": 1 }
      ],
      "almoco": [
        { "receita_id": 1 },
        { "receita_id": 1 },
        { "receita_id": 1 }
      ],
      "lanche_tarde": [
        { "receita_id": 1 }
      ]
    },
    "quinta": {
      "lanche_manha": [
        { "receita_id": 1 },
        { "receita_id": 1 },
        { "receita_id": 1 }
      ],
      "almoco": [
        { "receita_id": 1 },
        { "receita_id": 1 },
        { "receita_id": 1 }
      ],
      "lanche_tarde": [
        { "receita_id": 1 }
      ]
    },
    "sexta": {
      "lanche_manha": [
        { "receita_id": 1 },
        { "receita_id": 1 },
        { "receita_id": 1 }
      ],
      "almoco": [
        { "receita_id": 1 },
        { "receita_id": 1 },
        { "receita_id": 1 }
      ],
      "lanche_tarde": [
        { "receita_id": 1 }
      ]
    },
  }
}
 */