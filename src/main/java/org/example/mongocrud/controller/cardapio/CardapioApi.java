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
    ResponseEntity<List<CardapioResponseDTO>> getAllMenus();

    @Operation(summary = "Get a specific menu")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Menu successfully returned"),
            @ApiResponse(responseCode = "404", description = "Menu id not found"),
    })
    @GetMapping("/{id}")
    ResponseEntity<CardapioResponseDTO> getMenu(@PathVariable String id);

    @Operation(summary = "Save a new menu")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Menu successfully saved!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<CardapioResponseDTO> create(@Validated(OnCreate.class) @RequestBody CardapioRequestDTO request);

    @Operation(summary = "Update a menu")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Menu successfully updated!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PutMapping("/{id}")
    ResponseEntity<String> updateMenu(@PathVariable String id, @Validated(OnCreate.class) @RequestBody CardapioRequestDTO request);
}