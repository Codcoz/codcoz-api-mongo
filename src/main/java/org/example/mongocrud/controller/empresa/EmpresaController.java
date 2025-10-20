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
public class EmpresaController implements EmpresaApi{
    private final EmpresaService empresaService;

    @Override
    public ResponseEntity<List<EmpresaResponseDTO>> getAllEnterprises(){
        List<EmpresaResponseDTO> empresas = empresaService.listarEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @Override
    public ResponseEntity<EmpresaResponseDTO> getEnterprise(@PathVariable String id){
        EmpresaResponseDTO empresa = empresaService.buscarEmpresa(id);
        return ResponseEntity.ok(empresa);
    }

    @Override
    public ResponseEntity<EmpresaResponseDTO> create(@Validated(OnCreate.class) @RequestBody EmpresaRequestDTO empresaRequestDTO){
        EmpresaResponseDTO empresaResponse = empresaService.salvarEmpresa(empresaRequestDTO);
        return ResponseEntity.ok(empresaResponse);
    }

    @Override
    public ResponseEntity<String> updateEnterprise(@PathVariable String id, @Validated(OnCreate.class) @RequestBody EmpresaRequestDTO empresaRequestDTO){
        empresaService.atualizarEmpresa(id, empresaRequestDTO);
        return ResponseEntity.ok("Empresa alterada com sucesso");
    }
}
