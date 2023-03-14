package com.caito.usuarioms.controller;

import com.caito.usuarioms.dto.PageableResponseDTO;
import com.caito.usuarioms.dto.UsuarioDTO;
import com.caito.usuarioms.dto.UsuarioNuevoDTO;
import com.caito.usuarioms.service.contracts.UsuarioService;
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
 * @author  caito Vilas
 */

@RestController
@RequestMapping("/api/v1/cuenta-comercio/usuarios")
@Tag(name = "Cuenta Comercios - USUARIOS")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Operation(description = "alta de usuarios", summary = "alta de usuarios")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "created"),
            @ApiResponse(responseCode = "400", description = "bad request"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<UsuarioDTO> crete(@RequestBody UsuarioNuevoDTO dto){
        return new ResponseEntity<>(usuarioService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(description = "consulta todos las usuarios",
            summary = "consulta todos los usuarios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "204", description = "not content"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<List<UsuarioDTO>> getAll(){
        List<UsuarioDTO> usuarios = usuarioService.getAll();
        if (usuarios.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/paginado")
    @Operation(description = "consulta todos las usuarios paginado",
            summary = "consulta todos los usuarios paginado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "204", description = "not content"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<PageableResponseDTO<UsuarioDTO>> getAllPaginado(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10")int size){
       PageableResponseDTO<UsuarioDTO> usuarios = usuarioService.getAllPaginado(page, size);
        if (usuarios.getContent().isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    @Operation(description = "buscar usuario por id si existe",
            summary = "buscar usuario por id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "eliminar usuario por id si existe",
            summary = "eliminar usuario por id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "401", description = "unauthorized"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        usuarioService.delteUser(id);
        return ResponseEntity.ok(null);
    }
}
