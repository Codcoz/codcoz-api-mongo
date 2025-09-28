package org.example.mongocrud.service;

import org.example.mongocrud.model.HistoricoChat;
import org.example.mongocrud.model.Message;
import org.example.mongocrud.repository.HistoricoChatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HistoricoChatService {
    private HistoricoChatRepository historicoChatRepository;
    public HistoricoChatService(HistoricoChatRepository historicoChatRepository){
        this.historicoChatRepository = historicoChatRepository;
    }

    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong-service");
    }

    public List<HistoricoChat> todos() {
        List<HistoricoChat> all = historicoChatRepository.findAll();
        return all;
    }

    public HistoricoChat find(String id) {
        Optional<HistoricoChat> historicoChat = historicoChatRepository.findById(id);
        return historicoChat.get();
    }

    public String insertMessage(String chatId, String message) {
        Optional<HistoricoChat> historicoChatResponse = historicoChatRepository.findById(chatId);

        if(historicoChatResponse.isPresent()){
            HistoricoChat historicoChat = historicoChatResponse.get();
            List<Message> mensagens = historicoChat.getMensagens();

            //pegando os dados da ultima mensagem
            String origemMensagem = mensagens.getLast().getOrigem();
            Integer index = mensagens.getLast().getIndex();

            String novaOrigem = origemMensagem.equals("IA") ? "User" : "IA";

            //Nova mensagem
            Message mensagem = new Message(index+1, message, LocalDate.now(), novaOrigem);
            mensagens.add(mensagem);
            historicoChat.setMensagens(mensagens);
            historicoChatRepository.save(historicoChat);
            return "inserido";
        }
        return "nao foi inserido";
    }
}
