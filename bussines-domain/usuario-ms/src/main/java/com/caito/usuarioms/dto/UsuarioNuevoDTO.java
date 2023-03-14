package com.caito.usuarioms.dto;

import com.caito.usuarioms.enums.RolName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que representa un usuario para la creacion")
public class UsuarioNuevoDTO {
    @Schema(name = "username", required = true, example = "Claudio")
    private String username;
    @Schema(name = "password", required = true, example = "Vilas")
    private String password;
    @Schema(name = "persona")
    private PersonaNuevaDTO persona;
    @Schema(name = "rol", required = true, example = "ROLE_ADMIN")
    private RolName rol;

}
