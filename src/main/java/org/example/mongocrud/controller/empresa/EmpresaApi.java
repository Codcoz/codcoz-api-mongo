package org.example.mongocrud.controller.empresa;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.mongocrud.dto.empresa.EmpresaRequestDTO;
import org.example.mongocrud.dto.empresa.EmpresaResponseDTO;
import org.example.mongocrud.validation.OnCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Empresa", description = "Operações sobre a empresa")
public interface EmpresaApi {

    @GetMapping
    ResponseEntity<List<EmpresaResponseDTO>> getAllEnterprises();

    @Operation(summary = "Get a specific enterprise")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Enterprise successfully returned"),
            @ApiResponse(responseCode = "404", description = "Enterprise id not found"),
    })
    @GetMapping("/{id}")
    ResponseEntity<EmpresaResponseDTO> getEnterprise(@PathVariable String id);

    @Operation(summary = "Save a new enterprise")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Enterprise successfully saved!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<EmpresaResponseDTO> create(@Validated(OnCreate.class) @RequestBody EmpresaRequestDTO empresaRequestDTO);

    @Operation(summary = "Update an enterprise")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Enterprise successfully updated!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PutMapping("/{id}")
    ResponseEntity<String> updateEnterprise(@PathVariable String id, @Validated(OnCreate.class) @RequestBody EmpresaRequestDTO empresaRequestDTO);
}
