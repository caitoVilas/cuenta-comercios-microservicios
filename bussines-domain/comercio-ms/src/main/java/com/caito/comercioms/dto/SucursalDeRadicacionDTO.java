package com.caito.comercioms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que representa una sucursal de radicacion en las respuestas")
public class SucursalDeRadicacionDTO {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "name", example = "CABA")
    private String name;
    @Schema(name = "code", example = "1000")
    private String code;
}
