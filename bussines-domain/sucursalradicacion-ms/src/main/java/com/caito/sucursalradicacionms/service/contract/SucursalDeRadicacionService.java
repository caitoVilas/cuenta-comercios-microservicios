package com.caito.sucursalradicacionms.service.contract;

import com.caito.sucursalradicacionms.dto.PageableResponseDTO;
import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionDTO;
import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionNuevaDTO;

import java.util.List;

public interface SucursalDeRadicacionService {
    SucursalDeRadicacionDTO create(SucursalDeRadicacionNuevaDTO dto);
    SucursalDeRadicacionDTO getByid(Long id);
    SucursalDeRadicacionDTO getByCode(String code);
    List<SucursalDeRadicacionDTO> getAll();
    PageableResponseDTO<SucursalDeRadicacionDTO> getAllPaginado(int page, int size);
}
