package org.example.mongocrud.controller.receita;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.example.mongocrud.dto.receita.ReceitaRequestDTO;
import org.example.mongocrud.dto.receita.ReceitaResponseDTO;
import org.example.mongocrud.validation.OnCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Receita", description = "Recipe's operations")
public interface ReceitaApi {
    @Operation(summary = "Save a new recipe")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ingredient successfully saved!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<ReceitaResponseDTO> create(@Validated({OnCreate.class, Default.class}) @RequestBody ReceitaRequestDTO request);

    @Operation(summary = "Get a specific recipe")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Recipe successfully returned"),
            @ApiResponse(responseCode = "404", description = "Recipe id not found"),
    })
    @GetMapping("/{recipeId}")
    ResponseEntity<ReceitaResponseDTO> getRecipe(@PathVariable String recipeId);

    @Operation(summary = "List all recipes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All recipes returned successfully")
    })
    @GetMapping()
    ResponseEntity<List<ReceitaResponseDTO>> getAllRecipes();

    @Operation(summary = "Update a recipe")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Recipe successfully updated!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PutMapping("/{id}")
    ResponseEntity<String> updateRecipe(@PathVariable String id, @Validated(OnCreate.class) @RequestBody ReceitaRequestDTO receitaRequestDTO);
}