package org.example.mongocrud.controller.historico;

import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.historico.HistoricoChatRequestDTO;
import org.example.mongocrud.dto.historico.HistoricoChatResponseDTO;
import org.example.mongocrud.model.historico.HistoricoChat;
import org.example.mongocrud.service.historico.HistoricoChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/historico-chat")
public class HistoricoChatController implements HistoricoChatApi {
    private final HistoricoChatService historicoChatService;

    @Override
    public ResponseEntity<HistoricoChatResponseDTO> create(HistoricoChatRequestDTO request) {
        HistoricoChatResponseDTO historicoChat = historicoChatService.salvarChat(request);
        return ResponseEntity.ok(historicoChat);
    }

    @Override
    public ResponseEntity<HistoricoChatResponseDTO> getChat(String chatId) {
        HistoricoChatResponseDTO chat = historicoChatService.buscarChat(chatId);
        return ResponseEntity.ok(chat);
    }

    @Override
    public ResponseEntity<List<HistoricoChatResponseDTO>> getAllChats() {
        List<HistoricoChatResponseDTO> chats = historicoChatService.listarChats();
        return ResponseEntity.ok(chats);
    }
}