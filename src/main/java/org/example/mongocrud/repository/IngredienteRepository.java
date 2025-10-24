package org.example.mongocrud.repository;

import org.example.mongocrud.model.ingrediente.Ingrediente;
import org.example.mongocrud.model.receita.Receita;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends MongoRepository<Ingrediente,String> {
    @Query("{ '$or': [ { 'empresaId': ?0 }, { 'empresaId': { '$exists': false } } ] }")
    List<Receita> findByEmpresaIdOrWithoutEmpresaId(Long empresaId);
}
