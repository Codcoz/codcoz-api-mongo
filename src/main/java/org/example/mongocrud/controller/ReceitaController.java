package org.example.mongocrud.controller;

import org.example.mongocrud.model.HistoricoChat;
import org.example.mongocrud.model.Receita;
import org.example.mongocrud.service.HistoricoChatService;
import org.example.mongocrud.service.ReceitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/receita")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService){
        this.receitaService = receitaService;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/ping-service")
    public ResponseEntity<String> pingService() {
        return receitaService.ping();
    }

    // POST para salvar um TextoModel (body JSON -> TextoModel)
    @PostMapping
    public ResponseEntity<Receita> create(@RequestBody Receita receita) {
        Receita saved = receitaService.inserirReceita(receita);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{receitaId}")
    public ResponseEntity<Receita> getChat(@PathVariable String receitaId){
        Receita receita = receitaService.find(receitaId);
        return ResponseEntity.ok(receita);
    }
    @GetMapping()
    public ResponseEntity<List<Receita>> getAllChats(){
        List<Receita> all = receitaService.todos();
        return ResponseEntity.ok(all);
    }
    @DeleteMapping
    public ResponseEntity<Receita> deleteReceita(@RequestBody String id){ //retornar o objeto deletado
        Receita receitaDeletada = receitaService.delete(id);
        return ResponseEntity.ok(receitaDeletada);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Receita> updateReceita(@PathVariable String id, @RequestBody Receita receita){ //alterar receita
//        Receita receitaUpdate = receitaService.updateReceita(id, receita);
//    }


    /*

alterar uma receita
	(add um ingrediente e alterações de campo mesmo)

*/
//    @PostMapping("/{chatId}")
//    public ResponseEntity<String> insertMessage(@PathVariable String chatId, @RequestBody String message){
//        String mensagem = historicoChatService.insertMessage(chatId, message);
//        return ResponseEntity.ok(mensagem);
//    }
}
