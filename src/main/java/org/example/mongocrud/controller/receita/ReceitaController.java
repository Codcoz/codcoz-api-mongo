package org.example.mongocrud.controller.receita;

import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.receita.ReceitaRequestDTO;
import org.example.mongocrud.dto.receita.ReceitaResponseDTO;
import org.example.mongocrud.service.ReceitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/empresa/{empresaId}/receita")
public class ReceitaController implements ReceitaApi {
    private final ReceitaService receitaService;

    @Override
    public ResponseEntity<ReceitaResponseDTO> create(String empresaId, ReceitaRequestDTO request) {
        ReceitaResponseDTO receita = receitaService.salvarReceita(request);
        return ResponseEntity.ok(receita);
    }

    @Override
    public ResponseEntity<ReceitaResponseDTO> getRecipe(String empresaId, String id) {
        ReceitaResponseDTO receita = receitaService.buscarReceita(id);
        return ResponseEntity.ok(receita);
    }

    @Override
    public ResponseEntity<List<ReceitaResponseDTO>> getAllRecipes(String empresaId) {
        List<ReceitaResponseDTO> receitas = receitaService.listarReceitas(empresaId);
        return ResponseEntity.ok(receitas);
    }

    @Override
    public ResponseEntity<String> updateRecipe(String empresaId, String id, ReceitaRequestDTO receitaRequestDTO) {
        receitaService.atualizarReceita(id, receitaRequestDTO);
        return ResponseEntity.ok("Receita alterada com sucesso");
    }
}
