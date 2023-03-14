package com.caito.usuarioms.dto;

import com.caito.usuarioms.enums.RolName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que representa un rol para las respuestas")
public class RolDTO {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "rolName", example = "ROLE_ADMIN")
    private RolName rolName;
}
