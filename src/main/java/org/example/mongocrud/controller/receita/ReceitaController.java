package org.example.mongocrud.controller.receita;

import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.receita.ReceitaRequestDTO;
import org.example.mongocrud.dto.receita.ReceitaResponseDTO;
import org.example.mongocrud.service.ReceitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/empresa/{empresaId}/receita")
public class ReceitaController implements ReceitaApi {
    private final ReceitaService receitaService;

    @Override
    public ResponseEntity<ReceitaResponseDTO> create(Long empresaId, ReceitaRequestDTO request) {
        ReceitaResponseDTO receita = receitaService.salvarReceita(request);
        return ResponseEntity.ok(receita);
    }

    @Override
    public ResponseEntity<ReceitaResponseDTO> getRecipe(Long empresaId, String recipeId) {
        ReceitaResponseDTO receita = receitaService.buscarReceita(recipeId);
        return ResponseEntity.ok(receita);
    }

    @Override
    public ResponseEntity<List<ReceitaResponseDTO>> getAllRecipes(Long empresaId) {
        List<ReceitaResponseDTO> receitas = receitaService.listarReceitas(empresaId);
        return ResponseEntity.ok(receitas);
    }

    @Override
    public ResponseEntity<String> updateRecipe(Long empresaId, String recipeId, ReceitaRequestDTO receitaRequestDTO) {
        receitaService.atualizarReceita(recipeId, receitaRequestDTO);
        return ResponseEntity.ok("Receita alterada com sucesso");
    }
}
