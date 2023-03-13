package com.caito.sucursalradicacionms.mapper;

import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionDTO;
import com.caito.sucursalradicacionms.entity.SucursalDeRadicacion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SucursalDeRadicacionMapper {
    SucursalDeRadicacionDTO sucTosucDTO(SucursalDeRadicacion request);
    List<SucursalDeRadicacionDTO> sucListToSucDTOList(List<SucursalDeRadicacion> request);
}
