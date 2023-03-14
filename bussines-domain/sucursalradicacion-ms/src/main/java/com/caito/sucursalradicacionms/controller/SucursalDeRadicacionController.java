package com.caito.sucursalradicacionms.controller;

import com.caito.sucursalradicacionms.dto.PageableResponseDTO;
import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionDTO;
import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionNuevaDTO;
import com.caito.sucursalradicacionms.service.contract.SucursalDeRadicacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: caito Vilas
 */

@RestController
@RequestMapping("/api/v1/cuenta-comercio/sucursales-radicacion")
@Tag(name = "Cuenta Comercios - SUCURSAL DE RADICACION")
public class SucursalDeRadicacionController {
    @Autowired
    private SucursalDeRadicacionService sucursalDeRadicacionService;

    @PostMapping
    @Operation(description = "alta de sucursales de radicacion",
            summary = "alta de sucursales de radicacion")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "created"),
            @ApiResponse(responseCode = "400", description = "bad request"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<SucursalDeRadicacionDTO> crete(@RequestBody SucursalDeRadicacionNuevaDTO dto){
        return new ResponseEntity<>(sucursalDeRadicacionService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(description = "consulta sucursal de radicion x id si existe",
            summary = "consulta sucursal de radicacion x id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<SucursalDeRadicacionDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(sucursalDeRadicacionService.getByid(id));
    }

    @GetMapping("/codigo/{code}")
    @Operation(description = "consulta sucursal de radicion x codigo si existe",
            summary = "consulta sucursal de radicacion x codigo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<SucursalDeRadicacionDTO> getByCode(@PathVariable String code){
        return ResponseEntity.ok(sucursalDeRadicacionService.getByCode(code));
    }

    @GetMapping
    @Operation(description = "consulta todas las sucursales de radicion",
            summary = "consulta todas las sucursales de radicacion")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "204", description = "not content"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<List<SucursalDeRadicacionDTO>> getAll(){
        List<SucursalDeRadicacionDTO> sucursales = sucursalDeRadicacionService.getAll();
        if (sucursales.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(sucursales);
    }

    @GetMapping("/paginado")
    @Operation(description = "consulta todas las sucursales de radicion paginado",
            summary = "consulta todas las sucursales de radicacion paginado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "204", description = "not content"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<PageableResponseDTO<SucursalDeRadicacionDTO>> getAllPaginado(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size){
       PageableResponseDTO<SucursalDeRadicacionDTO> sucursales = sucursalDeRadicacionService.getAllPaginado(
               page, size);
        if (sucursales.getContent().isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(sucursales);
    }
}
