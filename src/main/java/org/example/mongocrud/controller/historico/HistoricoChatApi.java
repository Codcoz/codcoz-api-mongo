package org.example.mongocrud.controller.historico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.example.mongocrud.dto.historico.HistoricoChatRequestDTO;
import org.example.mongocrud.dto.historico.HistoricoChatResponseDTO;
import org.example.mongocrud.validation.OnCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "HistoricoChat", description = "Chat History's operations")
public interface HistoricoChatApi {
    @Operation(summary = "Save a new chat history")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Chat successfully saved!"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<HistoricoChatResponseDTO> create(@Validated({OnCreate.class, Default.class}) @RequestBody HistoricoChatRequestDTO request);

    @Operation(summary = "Get a specific chat")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Chat successfully returned"),
            @ApiResponse(responseCode = "404", description = "Chat id not found"),
    })
    @GetMapping("/{chatId}")
    ResponseEntity<HistoricoChatResponseDTO> getChat(@PathVariable String chatId);

    @Operation(summary = "List all chats")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All chats returned successfully")
    })
    @GetMapping()
    ResponseEntity<List<HistoricoChatResponseDTO>> getAllChats();
}