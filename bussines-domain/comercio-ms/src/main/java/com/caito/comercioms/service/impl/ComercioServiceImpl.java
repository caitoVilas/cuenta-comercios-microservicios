package com.caito.comercioms.service.impl;

import com.caito.comercioms.constants.ErrorMsg;
import com.caito.comercioms.dto.ComercioDTO;
import com.caito.comercioms.dto.ComercioNuevoDTO;
import com.caito.comercioms.dto.PagebleResponseDTO;
import com.caito.comercioms.entity.Comercio;
import com.caito.comercioms.enums.EstadoComercio;
import com.caito.comercioms.exceptions.BadRequestException;
import com.caito.comercioms.exceptions.NotFoundException;
import com.caito.comercioms.mapper.ComercioMapper;
import com.caito.comercioms.repository.ComercioRepository;
import com.caito.comercioms.service.contract.ComercioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: caito Vilas
 */

@Service
@Slf4j
public class ComercioServiceImpl implements ComercioService {
    @Autowired
    private ComercioRepository comercioRepository;
    @Autowired
    private ComercioMapper comercioMapper;


    @Override
    public ComercioDTO create(ComercioNuevoDTO dto) {
        log.info("iniciando servicio creacion comercio");
        log.info("validando datos...");
        this.validarComercio(dto);
        log.info("datos ok");
        log.info("guardando comercio...");
        Comercio comercio = this.armarComercio(dto);
        return comercioMapper.comerdioToComercioDTO(comercioRepository.save(comercio));
    }



    @Override
    public ComercioDTO findById(Long id) {
        log.info("inicio buscar comercio por id");
        log.info("buscando comercio...");
        Comercio comercio = comercioRepository.findById(id).orElseThrow(()->{
            log.error(ErrorMsg.COMERCIO_NOT_FOUND);
            throw new NotFoundException(ErrorMsg.COMERCIO_NOT_FOUND);
        });
        return comercioMapper.comerdioToComercioDTO(comercio);
    }

    @Override
    public PagebleResponseDTO<ComercioDTO> getAllPaginado(int page, int size) {
        log.info("inicio servicio mostrar comercios paginado");
        if (page <= 0){
            log.error(ErrorMsg.PAGE_GREATHER_ZERO);
            throw new BadRequestException(ErrorMsg.PAGE_GREATHER_ZERO);
        }
        log.info("buscando comercios...");
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Comercio> c = comercioRepository.findAll(pageable);
        List<ComercioDTO> comercios = comercioMapper.comercioListToComercioDTOList(c.getContent());
        PagebleResponseDTO<ComercioDTO> response = new PagebleResponseDTO<>();
        response.setPage(c.getNumber() + 1);
        response.setResults(c.getTotalElements());
        response.setTotalPages(c.getTotalPages());
        response.setContent(comercios);
        return response;
    }

    private void validarComercio(ComercioNuevoDTO dto){
        if (comercioRepository.existsByCuit(dto.getCuit())){
            log.error(ErrorMsg.CUIT_EXISTS);
            throw new BadRequestException(ErrorMsg.CUIT_EXISTS);
        }
        if (comercioRepository.existsByEmail(dto.getEmail())){
            log.error(ErrorMsg.EMAIL_EXISTS);
            throw new BadRequestException(ErrorMsg.EMAIL_EXISTS);
        }
    }

    private Comercio armarComercio(ComercioNuevoDTO dto) {
        Comercio comercio = new Comercio();
        comercio.setRazonSocial(dto.getRazonSocial());
        comercio.setDomicilio(dto.getDomicilio());
        comercio.setLocalidad(dto.getLocalidad());
        comercio.setProvincia(dto.getProvincia());
        comercio.setEmail(dto.getEmail());
        comercio.setCategoria(dto.getCategoria());
        comercio.setCuit(dto.getCuit());
        comercio.setTelefono(dto.getTelefono());
        comercio.setEstadoComercio(EstadoComercio.DOCUMENTACION_PENDIENTE);
        return comercio;
    }
}
