package org.example.mongocrud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.empresa.EmpresaRequestDTO;
import org.example.mongocrud.dto.empresa.EmpresaResponseDTO;
import org.example.mongocrud.exception.EntityNotFoundException;
import org.example.mongocrud.model.empresa.Empresa;
import org.example.mongocrud.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final ObjectMapper objectMapper;

    private Empresa getById(String id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
    }

    public EmpresaResponseDTO buscarEmpresa(String id){
        return objectMapper.convertValue(getById(id), EmpresaResponseDTO.class);
    }

    public List<EmpresaResponseDTO> listarEmpresas() {
        return empresaRepository.findAll().stream().map(e -> objectMapper.convertValue(e, EmpresaResponseDTO.class)).toList();
    }

    @Transactional
    public EmpresaResponseDTO salvarEmpresa(EmpresaRequestDTO empresaRequest){
        Empresa empresa = objectMapper.convertValue(empresaRequest, Empresa.class);
        return objectMapper.convertValue(empresaRepository.save(empresa), EmpresaResponseDTO.class);
    }

    @Transactional
    public void atualizarEmpresa(String id, EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = this.getById(id);
        BeanUtils.copyProperties(empresaRequestDTO, empresa);

        empresaRepository.save(empresa);
    }
}