package com.caito.usuarioms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que representa un usuario para las respuestas")
public class UsuarioDTO {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "username", required = true, example = "Claudio")
    private String username;
    @Schema(name = "persona")
    private PersonaDTO persona;
    @Schema(name = "roles", required = true, example = "ROLE_ADMIN")
    private List<RolDTO> roles;
}
