package org.example.mongocrud.repository;

import org.example.mongocrud.model.receita.Receita;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends MongoRepository<Receita, String> {
}
