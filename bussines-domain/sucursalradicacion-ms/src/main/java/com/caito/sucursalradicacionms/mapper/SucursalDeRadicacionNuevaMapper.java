package com.caito.sucursalradicacionms.mapper;

import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionNuevaDTO;
import com.caito.sucursalradicacionms.entity.SucursalDeRadicacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SucursalDeRadicacionNuevaMapper {
    SucursalDeRadicacion srDTOToSr(SucursalDeRadicacionNuevaDTO request);
}
