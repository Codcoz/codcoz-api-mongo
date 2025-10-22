package org.example.mongocrud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.historico.HistoricoChatRequestDTO;
import org.example.mongocrud.dto.historico.HistoricoChatResponseDTO;
import org.example.mongocrud.exception.EntityNotFoundException;
import org.example.mongocrud.model.historico.HistoricoChat;
import org.example.mongocrud.repository.HistoricoChatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HistoricoChatService {
    private final HistoricoChatRepository historicoChatRepository;
    private final ObjectMapper objectMapper;

    private HistoricoChat getById(String id) {
        return historicoChatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Chat não encontrada"));
    }

    public List<HistoricoChatResponseDTO> listarChats() {
        return historicoChatRepository.findAll().stream().map(e -> objectMapper.convertValue(e, HistoricoChatResponseDTO.class)).toList();
    }

    public HistoricoChatResponseDTO buscarChat(String chatId) {
        return objectMapper.convertValue(getById(chatId), HistoricoChatResponseDTO.class);
    }

    @Transactional
    public HistoricoChatResponseDTO salvarChat(HistoricoChatRequestDTO request) {
        HistoricoChat chat = objectMapper.convertValue(request, HistoricoChat.class);
        return objectMapper.convertValue(historicoChatRepository.save(chat), HistoricoChatResponseDTO.class);
    }
}