package org.example.mongocrud.controller.cardapio;

import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.cardapio.CardapioRequestDTO;
import org.example.mongocrud.dto.cardapio.CardapioResponseDTO;
import org.example.mongocrud.service.CardapioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cardapio")
public class CardapioController implements CardapioApi{
    private final CardapioService cardapioService;

    @Override
    public ResponseEntity<List<CardapioResponseDTO>> getAllMenus() {
        List<CardapioResponseDTO> cardapios = cardapioService.listarCardapios();
        return ResponseEntity.ok(cardapios);
    }

    @Override
    public ResponseEntity<CardapioResponseDTO> getMenu(String id) {
        CardapioResponseDTO cardapio = cardapioService.buscarCardapio(id);
        return ResponseEntity.ok(cardapio);
    }

    @Override
    public ResponseEntity<CardapioResponseDTO> create(CardapioRequestDTO request) {
        CardapioResponseDTO cardapio = cardapioService.salvarCardapio(request);
        return ResponseEntity.ok(cardapio);
    }

    @Override
    public ResponseEntity<String> updateMenu(String id, CardapioRequestDTO request) {
        cardapioService.atualizarCardapio(id, request);
        return ResponseEntity.ok("Cardápio alterado com sucesso");
    }
}