package org.example.mongocrud.controller.ingrediente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.example.mongocrud.dto.ingrediente.IngredienteRequestDTO;
import org.example.mongocrud.dto.ingrediente.IngredienteResponseDTO;
import org.example.mongocrud.validation.OnCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ingrediente", description = "Ingredient's operations")
public interface IngredienteApi {
    @Operation(summary = "Save a new ingredient")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ingredient successfully saved!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<IngredienteResponseDTO> create(@PathVariable Long empresaId, @Validated({OnCreate.class, Default.class}) @RequestBody IngredienteRequestDTO request);

    @Operation(summary = "Get a specific ingredient")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ingredient successfully returned"),
            @ApiResponse(responseCode = "404", description = "Chat id not found"),
    })
    @GetMapping("/{ingredientId}")
    ResponseEntity<IngredienteResponseDTO> getIngredient(@PathVariable Long empresaId, @PathVariable String ingredientId);

    @Operation(summary = "List all ingredients")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All ingredients returned successfully")
    })
    @GetMapping()
    ResponseEntity<List<IngredienteResponseDTO>> getAllIngredients(@PathVariable Long empresaId);

    @Operation(summary = "Update an ingredient")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ingredient successfully updated!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PutMapping("/{ingredientId}")
    ResponseEntity<String> updateIngredient(@PathVariable Long empresaId, @PathVariable String ingredientId, @Validated(OnCreate.class) @RequestBody IngredienteRequestDTO ingredienteRequestDTO);

}