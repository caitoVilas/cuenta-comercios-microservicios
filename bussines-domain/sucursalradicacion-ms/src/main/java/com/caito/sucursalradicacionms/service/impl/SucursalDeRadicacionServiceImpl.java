package com.caito.sucursalradicacionms.service.impl;

import com.caito.sucursalradicacionms.constants.ErrorMsg;
import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionDTO;
import com.caito.sucursalradicacionms.dto.SucursalDeRadicacionNuevaDTO;
import com.caito.sucursalradicacionms.entity.SucursalDeRadicacion;
import com.caito.sucursalradicacionms.exceptions.BadRequestException;
import com.caito.sucursalradicacionms.exceptions.NotFoundException;
import com.caito.sucursalradicacionms.mapper.SucursalDeRadicacionMapper;
import com.caito.sucursalradicacionms.mapper.SucursalDeRadicacionNuevaMapper;
import com.caito.sucursalradicacionms.repository.SucursalDeRadicacionRepository;
import com.caito.sucursalradicacionms.service.contract.SucursalDeRadicacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SucursalDeRadicacionServiceImpl implements SucursalDeRadicacionService {
    @Autowired
    private SucursalDeRadicacionRepository sucursalDeRadicacionRepository;
    @Autowired
    private SucursalDeRadicacionNuevaMapper sucursalDeRadicacionNuevaMapper;
    @Autowired
    private SucursalDeRadicacionMapper sucursalDeRadicacionMapper;


    @Override
    public SucursalDeRadicacionDTO create(SucursalDeRadicacionNuevaDTO dto) {
        log.info("inicio servicio alta de sucursal de radicacion");
        log.info("validando datos...");
        this.validandoSucursalDeRadicacion(dto);
        log.info("datos ok");
        log.info("guardadndo sucursal...");
        return sucursalDeRadicacionMapper.sucTosucDTO(sucursalDeRadicacionRepository.save(
                sucursalDeRadicacionNuevaMapper.srDTOToSr(dto)
        ));
    }

    @Override
    public SucursalDeRadicacionDTO getByid(Long id) {
        log.info("iniciando servicio buscar sucursal de radicacion por id");
        log.info("buscando sucursal...");
        SucursalDeRadicacion sucursalDeRadicacion = sucursalDeRadicacionRepository.findById(id).orElseThrow(()->{
            log.error(ErrorMsg.SUC_NOT_FOUND);
            throw new NotFoundException(ErrorMsg.SUC_NOT_FOUND);
        });
        return sucursalDeRadicacionMapper.sucTosucDTO(sucursalDeRadicacion);
    }

    @Override
    public SucursalDeRadicacionDTO getByCode(String code) {
        log.info("iniciando servicio buscar sucursal de radicacion por codigo");
        log.info("buscando sucursal...");
        SucursalDeRadicacion sucursalDeRadicacion = sucursalDeRadicacionRepository.findByCode(code)
                .orElseThrow(()-> {
                    log.error(ErrorMsg.SUC_NOT_FOUND);
                    throw new NotFoundException(ErrorMsg.SUC_NOT_FOUND);
                });
        return sucursalDeRadicacionMapper.sucTosucDTO(sucursalDeRadicacion);
    }

    private void validandoSucursalDeRadicacion(SucursalDeRadicacionNuevaDTO dto) {
        if (sucursalDeRadicacionRepository.existsByCode(dto.getCode())){
            log.error(ErrorMsg.SUC_CODE_EXISTS);
            throw new BadRequestException(ErrorMsg.SUC_CODE_EXISTS);
        }
        if (sucursalDeRadicacionRepository.existsByName(dto.getName())){
            log.error(ErrorMsg.SUC_NAME_EXISTS);
            throw new BadRequestException(ErrorMsg.SUC_NAME_EXISTS);
        }
    }
}
