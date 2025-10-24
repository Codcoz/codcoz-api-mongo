package org.example.mongocrud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.ingrediente.IngredienteRequestDTO;
import org.example.mongocrud.dto.ingrediente.IngredienteResponseDTO;
import org.example.mongocrud.exception.EntityNotFoundException;
import org.example.mongocrud.model.ingrediente.Ingrediente;
import org.example.mongocrud.repository.IngredienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredienteService {
    private final IngredienteRepository ingredienteRepository;
    private final ObjectMapper objectMapper;

    private Ingrediente getById(String id) {
        return ingredienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingrediente não encontrado"));
    }

    public List<IngredienteResponseDTO> listarIngredientes(Long empresaId) {
        return ingredienteRepository.findByEmpresaIdOrWithoutEmpresaId(empresaId).stream().map(e -> objectMapper.convertValue(e, IngredienteResponseDTO.class)).toList();
    }

    public IngredienteResponseDTO buscarIngrediente(String chatId) {
        return objectMapper.convertValue(getById(chatId), IngredienteResponseDTO.class);
    }

    @Transactional
    public IngredienteResponseDTO salvarIngrediente(IngredienteRequestDTO request) {
        Ingrediente ingrediente = objectMapper.convertValue(request, Ingrediente.class);
        return objectMapper.convertValue(ingredienteRepository.save(ingrediente), IngredienteResponseDTO.class);
    }

    @Transactional
    public void atualizarIngrediente(String id, IngredienteRequestDTO ingredienteRequestDTO) {
        Ingrediente ingrediente = this.getById(id);
        BeanUtils.copyProperties(ingredienteRequestDTO, ingrediente);

        ingredienteRepository.save(ingrediente);
    }
}