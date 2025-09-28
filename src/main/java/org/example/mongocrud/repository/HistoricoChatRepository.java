package org.example.mongocrud.repository;

import org.example.mongocrud.model.HistoricoChat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoChatRepository extends MongoRepository<HistoricoChat, String> {
}
