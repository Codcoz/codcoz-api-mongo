package org.example.mongocrud.controller.empresa;

import lombok.RequiredArgsConstructor;
import org.example.mongocrud.dto.empresa.EmpresaRequestDTO;
import org.example.mongocrud.dto.empresa.EmpresaResponseDTO;
import org.example.mongocrud.model.empresa.Empresa;
import org.example.mongocrud.service.empresa.EmpresaService;
import org.example.mongocrud.validation.OnCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDTO>> listarEmpresas(){
        List<EmpresaResponseDTO> empresas = empresaService.listarEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> buscarEmpresa(@PathVariable String id){
        EmpresaResponseDTO empresa = empresaService.buscarEmpresa(id);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> insert(@Validated(OnCreate.class) @RequestBody EmpresaRequestDTO empresaRequestDTO){
        EmpresaResponseDTO empresaResponse = empresaService.salvarEmpresa(empresaRequestDTO);
        return ResponseEntity.ok(empresaResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarEmpresa(@PathVariable String id, @Validated(OnCreate.class) @RequestBody EmpresaRequestDTO empresaRequestDTO){
        empresaService.atualizarEmpresa(id, empresaRequestDTO);
        return ResponseEntity.ok("Empresa alterada com sucesso");
    }
}
