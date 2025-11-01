package org.example.mongocrud.controller.cardapio;

import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.cardapio.CardapioRequestDTO;
import org.example.mongocrud.dto.cardapio.CardapioResponseDTO;
import org.example.mongocrud.service.CardapioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/empresa/{empresaId}/cardapio")
public class CardapioController implements CardapioApi{
    private final CardapioService cardapioService;

    @Override
    public ResponseEntity<List<CardapioResponseDTO>> getAllMenus(Long empresaId) {
        List<CardapioResponseDTO> cardapios = cardapioService.listarCardapios(empresaId);
        return ResponseEntity.ok(cardapios);
    }

    @Override
    public ResponseEntity<CardapioResponseDTO> getMenu(Long empresaId, String cardapioId) {
        CardapioResponseDTO cardapio = cardapioService.buscarCardapio(cardapioId);
        return ResponseEntity.ok(cardapio);
    }

    @Override
    public ResponseEntity<CardapioResponseDTO> create(Long empresaId, CardapioRequestDTO request) {
        CardapioResponseDTO cardapio = cardapioService.salvarCardapio(request);
        return ResponseEntity.ok(cardapio);
    }

    @Override
    public ResponseEntity<String> updateMenu(Long empresaId, String cardapioId, CardapioRequestDTO request) {
        cardapioService.atualizarCardapio(cardapioId, request);
        return ResponseEntity.ok("Cardápio alterado com sucesso");
    }

    @Override
    public ResponseEntity<String> deleteMenu(Long empresaId, String cardapioId) {
        cardapioService.deletarCardapio(cardapioId);
        return ResponseEntity.ok("Cardápio deletado com sucesso");
    }
}