package org.example.mongocrud.service;

import org.example.mongocrud.model.HistoricoChat;
import org.example.mongocrud.model.Message;
import org.example.mongocrud.model.Receita;
import org.example.mongocrud.repository.HistoricoChatRepository;
import org.example.mongocrud.repository.ReceitaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {
    private ReceitaRepository receitaRepository;
    public ReceitaService(ReceitaRepository receitaRepository){
        this.receitaRepository = receitaRepository;
    }

    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong-service");
    }

    public List<Receita> todos() {
        List<Receita> all = receitaRepository.findAll();
        return all;
    }

    public Receita find(String id) {
        Optional<Receita> receita = receitaRepository.findById(id);
        return receita.get();
    }

//    public Receita inserirReceita(Receita receita) {
//        Optional<Receita> receitaResponse = receitaRepository.findById();
//
//        if(receitaResponse.isPresent()){
//            HistoricoChat historicoChat = receitaResponse.get();
//            List<Message> mensagens = historicoChat.getMensagens();
//
//            //pegando os dados da ultima mensagem
//            String origemMensagem = mensagens.getLast().getOrigem();
//            Integer index = mensagens.getLast().getIndex();
//
//            String novaOrigem = origemMensagem.equals("IA") ? "User" : "IA";
//
//            //Nova mensagem
//            Message mensagem = new Message(index+1, message, LocalDate.now(), novaOrigem);
//            mensagens.add(mensagem);
//            historicoChat.setMensagens(mensagens);
//            receitaRepository.save(historicoChat);
//            return "inserido";
//        }
//        return "nao foi inserido";
//    }

    public Receita inserirReceita(Receita receita){
        Receita receitaResponse = receitaRepository.save(receita);
        return receitaResponse;
    }

    public Receita delete(String id) {
        Optional<Receita> receitaResponse = receitaRepository.findById(id);
        Receita receita = receitaResponse.get();
        receitaRepository.delete(receita);
        return receita;
    }
//
//    public ResponseEntity<Receita> updateReceita(String id, Receita receita){ //alterar receita
//
//    }
}
