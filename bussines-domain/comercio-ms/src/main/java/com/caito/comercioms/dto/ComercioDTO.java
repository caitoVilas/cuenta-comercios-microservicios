package com.caito.comercioms.dto;

import com.caito.comercioms.enums.Categoria;
import com.caito.comercioms.enums.EstadoComercio;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que representa un comercio para las respuestas")
public class ComercioDTO {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "razonSocial",example = "Quisko Piky")
    private String razonSocial;
    @Schema(name = "domicilio", example = "Molinedo 4277")
    private String domicilio;
    @Schema(name = "localidad", example = "Lanus")
    private String localidad;
    @Schema(name = "provincia", example = "Buenos Aires")
    private String provincia;
    @Schema(name = "email", example = "piqui.mail.com")
    private String email;
    @Schema(name = "categoria", example = "RI")
    private Categoria categoria;
    @Schema(name = "cuit", example = "11-12222333-9")
    private String cuit;
    @Schema(name = "telefono", example = "1167381033")
    private String telefono;
    @Schema(name = "estadoComercio", example = "DOCUMENTACION_PRESENTADA")
    private EstadoComercio estadoComercio;
    @Schema(name = "created")
    private LocalDateTime created;
    @Schema(name = "updated")
    private LocalDateTime updated;
}
