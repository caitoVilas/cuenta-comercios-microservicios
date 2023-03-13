package com.caito.sucursalradicacionms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que represnta una sucursal de radicacion para la creacion")
public class SucursalDeRadicacionNuevaDTO {
    @Schema(name = "name", required = true, example = "CABA")
    private String name;
    @Schema(name = "code", required = true, example = "1000")
    private String code;
}
