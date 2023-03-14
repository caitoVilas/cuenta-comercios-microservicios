package com.caito.usuarioms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que represena una persona para su creacion")
public class PersonaNuevaDTO {
    @Schema(name = "name", required = true, example = "Claudio")
    private String name;
    @Schema(name = "surname", required = true, example = "Vilas")
    private String surname;
    @Schema(name = "dni", required = true, example = "17405197")
    private String dni;
    @Schema(name = "domicilio", required = true, example = "E.Banchs 3260")
    private String domicilio;
    @Schema(name = "localidad", required = true, example = "Lanus")
    private String localidad;
    @Schema(name = "provincia", required = true, example = "Buenos Aires")
    private String provincia;
    @Schema(name = "telefono", required = false, example = "1167281038")
    private String telefono;
    @Schema(name = "email", required = true, example = "claudio.vilas@eldars.com.ar")
    private String email;
}
