package org.example.mongocrud.controller;

import org.example.mongocrud.model.HistoricoChat;
import org.example.mongocrud.service.HistoricoChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/historico-chat")
public class HistoricoChatController {
    private final HistoricoChatService historicoChatService;

    public HistoricoChatController(HistoricoChatService historicoChatService){
        this.historicoChatService = historicoChatService;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/ping-service")
    public ResponseEntity<String> pingService() {
        return historicoChatService.ping();
    }

    // POST para salvar um TextoModel (body JSON -> TextoModel)
//    @PostMapping
//    public ResponseEntity<TextoModel> create(@RequestBody TextoModel texto) {
//        TextoModel saved = textoRepository.save(texto);
//        return ResponseEntity.ok(saved);
//    }

    @GetMapping("/{chatId}")
    public ResponseEntity<HistoricoChat> getChat(@PathVariable String chatId){
        HistoricoChat historicoChat = historicoChatService.find(chatId);
        return ResponseEntity.ok(historicoChat);
    }
    @GetMapping()
    public ResponseEntity<List<HistoricoChat>> getAllChats(){
        List<HistoricoChat> all = historicoChatService.todos();
        return ResponseEntity.ok(all);
    }
    @PostMapping("/{chatId}")
    public ResponseEntity<String> insertMessage(@PathVariable String chatId, @RequestBody String message){
        String mensagem = historicoChatService.insertMessage(chatId, message);
        return ResponseEntity.ok(mensagem);
    }


}
