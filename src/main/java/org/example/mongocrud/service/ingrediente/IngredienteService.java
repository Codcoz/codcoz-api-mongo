package org.example.mongocrud.service.historico;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.empresa.EmpresaRequestDTO;
import org.example.mongocrud.dto.historico.HistoricoChatRequestDTO;
import org.example.mongocrud.dto.historico.HistoricoChatResponseDTO;
import org.example.mongocrud.dto.ingrediente.IngredienteRequestDTO;
import org.example.mongocrud.dto.ingrediente.IngredienteResponseDTO;
import org.example.mongocrud.model.empresa.Empresa;
import org.example.mongocrud.model.historico.HistoricoChat;
import org.example.mongocrud.model.ingrediente.Ingrediente;
import org.example.mongocrud.repository.HistoricoChatRepository;
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
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado")); //não to achando a EntityNotFoundException
    }

    public List<IngredienteResponseDTO> listarIngredientes() {
        return ingredienteRepository.findAll().stream().map(e -> objectMapper.convertValue(e, IngredienteResponseDTO.class)).toList();
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