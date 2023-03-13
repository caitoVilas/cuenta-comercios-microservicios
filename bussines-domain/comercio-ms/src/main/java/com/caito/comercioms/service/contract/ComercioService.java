package com.caito.comercioms.service.contract;

import com.caito.comercioms.dto.ComercioDTO;
import com.caito.comercioms.dto.ComercioNuevoDTO;
import com.caito.comercioms.dto.PagebleResponseDTO;

public interface ComercioService {
    ComercioDTO create(ComercioNuevoDTO dto);
    ComercioDTO findById(Long id);
    PagebleResponseDTO<ComercioDTO> getAllPaginado(int page, int size);
}
