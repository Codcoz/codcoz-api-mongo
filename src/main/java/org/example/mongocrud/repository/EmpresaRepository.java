package org.example.mongocrud.repository;

import org.example.mongocrud.model.empresa.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
}
