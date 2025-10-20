package org.example.mongocrud.repository.cardapio;

import org.example.mongocrud.model.cardapio.Cardapio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends MongoRepository<Cardapio, String> {
}
