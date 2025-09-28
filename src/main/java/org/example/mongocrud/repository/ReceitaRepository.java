package org.example.mongocrud.repository;

import org.example.mongocrud.model.Receita;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface ReceitaRepository extends MongoRepository<Receita, String> {
}
