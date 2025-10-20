package org.example.mongocrud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.cardapio.CardapioRequestDTO;
import org.example.mongocrud.dto.cardapio.CardapioResponseDTO;
import org.example.mongocrud.model.cardapio.Cardapio;
import org.example.mongocrud.repository.CardapioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CardapioService {
    private final CardapioRepository cardapioRepository;
    private final ObjectMapper objectMapper;

    private Cardapio getById(String id) {
        return cardapioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cardápio não encontrado"));
    }

    @Transactional
    public void atualizarCardapio(String id, CardapioRequestDTO request) {
        Cardapio cardapio = this.getById(id);
        BeanUtils.copyProperties(request, cardapio);

        cardapioRepository.save(cardapio);
    }

    @Transactional
    public CardapioResponseDTO salvarCardapio(CardapioRequestDTO request) {
        Cardapio cardapio = objectMapper.convertValue(request, Cardapio.class);
        return objectMapper.convertValue(cardapioRepository.save(cardapio), CardapioResponseDTO.class);
    }

    public CardapioResponseDTO buscarCardapio(String id) {
        return objectMapper.convertValue(getById(id), CardapioResponseDTO.class);
    }

    public List<CardapioResponseDTO> listarCardapios() {
        return cardapioRepository.findAll().stream().map(e -> objectMapper.convertValue(e, CardapioResponseDTO.class)).toList();
    }
}