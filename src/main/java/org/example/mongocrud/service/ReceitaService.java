package org.example.mongocrud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.receita.ReceitaRequestDTO;
import org.example.mongocrud.dto.receita.ReceitaResponseDTO;
import org.example.mongocrud.model.receita.Receita;
import org.example.mongocrud.repository.ReceitaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReceitaService {
    private final ReceitaRepository receitaRepository;
    private final ObjectMapper objectMapper;

    private Receita getById(String id) {
        return receitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada")); //não to achando a EntityNotFoundException
    }

    @Transactional
    public ReceitaResponseDTO salvarReceita(ReceitaRequestDTO request) {
        Receita receita = objectMapper.convertValue(request, Receita.class);
        return objectMapper.convertValue(receitaRepository.save(receita), ReceitaResponseDTO.class);
    }

    public ReceitaResponseDTO buscarReceita(String id) {
        return objectMapper.convertValue(getById(id), ReceitaResponseDTO.class);
    }

    public List<ReceitaResponseDTO> listarReceitas() {
        return receitaRepository.findAll().stream().map(e -> objectMapper.convertValue(e, ReceitaResponseDTO.class)).toList();
    }

    @Transactional
    public void atualizarReceita(String id, ReceitaRequestDTO receitaRequestDTO) {
        Receita receita = this.getById(id);
        BeanUtils.copyProperties(receitaRequestDTO, receita);

        receitaRepository.save(receita);
    }
}
