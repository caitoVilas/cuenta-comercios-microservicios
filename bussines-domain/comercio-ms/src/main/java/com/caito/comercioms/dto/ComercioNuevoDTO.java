package com.caito.comercioms.dto;

import com.caito.comercioms.enums.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que representa un comercio para su creacion")
public class ComercioNuevoDTO {
    @Schema(name = "razonSocial", required = true, example = "Quisko Piky")
    private String razonSocial;
    @Schema(name = "domicilio", required = true, example = "Molinedo 4277")
    private String domicilio;
    @Schema(name = "localidad", required = true, example = "Lanus")
    private String localidad;
    @Schema(name = "provincia", required = true, example = "Buenos Aires")
    private String provincia;
    @Schema(name = "email", required = true, example = "piqui.mail.com")
    private String email;
    @Schema(name = "categoria", required = true, example = "RI")
    private Categoria categoria;
    @Schema(name = "cuit", required = true, example = "11-12222333-9")
    private String cuit;
    @Schema(name = "telefono", required = false, example = "1167381033")
    private String telefono;
}
