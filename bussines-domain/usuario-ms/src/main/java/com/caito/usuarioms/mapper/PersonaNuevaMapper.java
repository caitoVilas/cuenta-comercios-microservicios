package com.caito.usuarioms.mapper;

import com.caito.usuarioms.dto.PersonaNuevaDTO;
import com.caito.usuarioms.entity.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaNuevaMapper {
    Persona personaDTOToPersona(PersonaNuevaDTO request);
}
