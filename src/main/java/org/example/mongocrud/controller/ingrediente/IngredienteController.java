package org.example.mongocrud.controller.ingrediente;

import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.ingrediente.IngredienteRequestDTO;
import org.example.mongocrud.dto.ingrediente.IngredienteResponseDTO;
import org.example.mongocrud.service.IngredienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/empresa/{empresaId}/ingrediente")
public class IngredienteController implements IngredienteApi {
    private final IngredienteService ingredienteService;

    @Override
    public ResponseEntity<IngredienteResponseDTO> create(String empresaId, IngredienteRequestDTO request) {
        IngredienteResponseDTO ingrediente = ingredienteService.salvarIngrediente(request);
        return ResponseEntity.ok(ingrediente);
    }

    @Override
    public ResponseEntity<IngredienteResponseDTO> getIngredient(String empresaId, String ingredienteId) {
        IngredienteResponseDTO ingrediente = ingredienteService.buscarIngrediente(ingredienteId);
        return ResponseEntity.ok(ingrediente);
    }

    @Override
    public ResponseEntity<List<IngredienteResponseDTO>> getAllIngredients(String empresaId) {
        List<IngredienteResponseDTO> ingredientes = ingredienteService.listarIngredientes(empresaId);
        return ResponseEntity.ok(ingredientes);
    }

    @Override
    public ResponseEntity<String> updateIngredient(String empresaId, String ingredienteId, IngredienteRequestDTO ingredienteRequestDTO) {
        ingredienteService.atualizarIngrediente(ingredienteId, ingredienteRequestDTO);
        return ResponseEntity.ok("Ingrediente alterado com sucesso");
    }
}