package com.caito.comercioms.mapper;

import com.caito.comercioms.dto.ComercioDTO;
import com.caito.comercioms.entity.Comercio;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComercioMapper {
    ComercioDTO comerdioToComercioDTO(Comercio request);
    List<ComercioDTO> comercioListToComercioDTOList(List<Comercio> request);
}
