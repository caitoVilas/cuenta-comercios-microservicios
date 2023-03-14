package com.caito.usuarioms.mapper;

import com.caito.usuarioms.dto.UsuarioDTO;
import com.caito.usuarioms.entity.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDTO usuarioToUsuarioDTO(Usuario request);
    List<UsuarioDTO> usuarioListToUsuarioDTOList(List<Usuario> request);
}
