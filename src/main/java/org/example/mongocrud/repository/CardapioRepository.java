package org.example.mongocrud.repository;

import org.example.mongocrud.model.cardapio.Cardapio;
import org.springframework.beans.PropertyValues;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardapioRepository extends MongoRepository<Cardapio, String> {
    List<Cardapio> findAllByEmpresaId(String empresaId);
}
