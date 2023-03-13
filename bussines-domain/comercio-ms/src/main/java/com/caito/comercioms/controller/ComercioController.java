package com.caito.comercioms.controller;

import com.caito.comercioms.dto.ComercioDTO;
import com.caito.comercioms.dto.ComercioNuevoDTO;
import com.caito.comercioms.dto.PagebleResponseDTO;
import com.caito.comercioms.service.contract.ComercioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cuenta-comercio/comercios")
@Tag(name = "Cuenta Comercios - COMERCIOS")
public class ComercioController {
    @Autowired
    private ComercioService comercioService;

    @PostMapping
    @Operation(description = "alta de comercios", summary = "alta de comercios")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "created"),
            @ApiResponse(responseCode = "400", description = "bad request"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<ComercioDTO> registroUsuario(@RequestBody ComercioNuevoDTO dto){
        return ResponseEntity.ok(comercioService.create(dto));
    }

    @GetMapping("/{id}")
    @Operation(description = "consulta comercio x id si existe", summary = "consulta comercio x id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<ComercioDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(comercioService.findById(id));
    }

    @GetMapping
    @Operation(description = "consulta todos los ´comercios paginado",
            summary = "consulta todos los comercios paginado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "204", description = "no content"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<PagebleResponseDTO<ComercioDTO>> verTodosPaginado(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size){
        PagebleResponseDTO<ComercioDTO> comercios = comercioService.getAllPaginado(page, size);
        if (comercios.getContent().isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(comercios);
    }
}
