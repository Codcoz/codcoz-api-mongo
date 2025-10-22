package org.example.mongocrud.repository;

import org.example.mongocrud.model.ingrediente.Ingrediente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends MongoRepository<Ingrediente,String> {
}
