package com.caito.sucursalradicacionms.service.contract;

import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionDTO;
import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionNuevaDTO;

public interface SucursalDeRadicacionService {
    SucursalDeRadicacionDTO create(SucursalDeRadicacionNuevaDTO dto);
    SucursalDeRadicacionDTO getByid(Long id);
    SucursalDeRadicacionDTO getByCode(String code);
}
