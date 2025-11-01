package org.example.mongocrud.controller.cardapio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.mongocrud.dto.cardapio.CardapioRequestDTO;
import org.example.mongocrud.dto.cardapio.CardapioResponseDTO;
import org.example.mongocrud.validation.OnCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cardápio", description = "Menu's operations")
public interface CardapioApi {
    @Operation(summary = "List all menus")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All menus returned successfully")
    })
    @GetMapping
    ResponseEntity<List<CardapioResponseDTO>> getAllMenus(@PathVariable Long empresaId);

    @Operation(summary = "Get a specific menu")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Menu successfully returned"),
            @ApiResponse(responseCode = "404", description = "Menu id not found"),
    })
    @GetMapping("/{cardapioId}")
    ResponseEntity<CardapioResponseDTO> getMenu(@PathVariable Long empresaId, @PathVariable String cardapioId);

    @Operation(summary = "Save a new menu")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Menu successfully saved!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<CardapioResponseDTO> create(@PathVariable Long empresaId, @Validated(OnCreate.class) @RequestBody CardapioRequestDTO request);

    @Operation(summary = "Update a menu")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Menu successfully updated!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PutMapping("/{cardapioId}")
    ResponseEntity<String> updateMenu(@PathVariable Long empresaId, @PathVariable String cardapioId, @Validated(OnCreate.class) @RequestBody CardapioRequestDTO request);

    @Operation(summary = "Delete a menu")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Menu successfully deleted!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @DeleteMapping("/{cardapioId}")
    ResponseEntity<String> deleteMenu(@PathVariable Long empresaId, @PathVariable String cardapioId);
}