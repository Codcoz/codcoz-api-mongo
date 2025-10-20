package org.example.mongocrud.controller.receita;

import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.receita.ReceitaRequestDTO;
import org.example.mongocrud.dto.receita.ReceitaResponseDTO;
import org.example.mongocrud.service.receita.ReceitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/receita")
public class ReceitaController implements ReceitaApi {
    private final ReceitaService receitaService;

    @Override
    public ResponseEntity<ReceitaResponseDTO> create(ReceitaRequestDTO request) {
        ReceitaResponseDTO receita = receitaService.salvarReceita(request);
        return ResponseEntity.ok(receita);
    }

    @Override
    public ResponseEntity<ReceitaResponseDTO> getRecipe(String id) {
        ReceitaResponseDTO receita = receitaService.buscarReceita(id);
        return ResponseEntity.ok(receita);
    }

    @Override
    public ResponseEntity<List<ReceitaResponseDTO>> getAllRecipes() {
        List<ReceitaResponseDTO> receitas = receitaService.listarReceitas();
        return ResponseEntity.ok(receitas);
    }

    @Override
    public ResponseEntity<String> updateRecipe(String id, ReceitaRequestDTO receitaRequestDTO) {
        receitaService.atualizarReceita(id, receitaRequestDTO);
        return ResponseEntity.ok("Receita alterada com sucesso");
    }
}
