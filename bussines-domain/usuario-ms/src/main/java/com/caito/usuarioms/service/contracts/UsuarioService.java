package com.caito.usuarioms.service.contracts;

import com.caito.usuarioms.dto.PageableResponseDTO;
import com.caito.usuarioms.dto.UsuarioDTO;
import com.caito.usuarioms.dto.UsuarioNuevoDTO;

import java.util.List;

/**
 * @author  caito Vilas
 */

public interface UsuarioService {
    UsuarioDTO create(UsuarioNuevoDTO dto);
    List<UsuarioDTO> getAll();
    PageableResponseDTO<UsuarioDTO> getAllPaginado(int page, int size);
    UsuarioDTO getById(Long id);
    void delteUser(Long id);
}
