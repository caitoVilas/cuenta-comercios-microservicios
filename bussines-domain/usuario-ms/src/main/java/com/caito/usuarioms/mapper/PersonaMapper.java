package com.caito.usuarioms.mapper;

import com.caito.usuarioms.dto.PersonaDTO;
import com.caito.usuarioms.entity.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDTO personaToPersonaDTO(Persona request);
    List<PersonaDTO> personaListToPersonaDTOList(List<Persona> request);
}
