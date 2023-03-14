package com.caito.usuarioms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que representa una persona para las respuestas")
public class PersonaDTO {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "name", example = "Claudio")
    private String name;
    @Schema(name = "surname", example = "Vilas")
    private String surname;
    @Schema(name = "dni", example = "17405197")
    private String dni;
    @Schema(name = "domicilio", example = "E.Banchs 3260")
    private String domicilio;
    @Schema(name = "localidad", example = "Lanus")
    private String localidad;
    @Schema(name = "provincia", example = "Buenos Aires")
    private String provincia;
    @Schema(name = "telefono", example = "1167281038")
    private String telefono;
    @Schema(name = "email", example = "claudio.vilas@eldars.com.ar")
    private String email;
}
