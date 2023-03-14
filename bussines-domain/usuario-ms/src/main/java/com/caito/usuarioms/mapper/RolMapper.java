package com.caito.usuarioms.mapper;

import com.caito.usuarioms.dto.RolDTO;
import com.caito.usuarioms.entity.Rol;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDTO rolToRolDTO(Rol request);
    List<RolDTO> rolListToRolDTOList(List<Rol> request);
}
