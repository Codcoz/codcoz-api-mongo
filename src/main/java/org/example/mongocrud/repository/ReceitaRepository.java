package org.example.mongocrud.repository;

import org.example.mongocrud.model.receita.Receita;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends MongoRepository<Receita, String> {
    List<Receita> findByEmpresaId(String empresaId);
}
