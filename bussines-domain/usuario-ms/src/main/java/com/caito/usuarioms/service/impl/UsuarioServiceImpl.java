package com.caito.usuarioms.service.impl;

import com.caito.usuarioms.constants.ErrorMsg;
import com.caito.usuarioms.dto.PageableResponseDTO;
import com.caito.usuarioms.dto.UsuarioDTO;
import com.caito.usuarioms.dto.UsuarioNuevoDTO;
import com.caito.usuarioms.entity.Rol;
import com.caito.usuarioms.entity.Usuario;
import com.caito.usuarioms.exceptions.BadRequestException;
import com.caito.usuarioms.exceptions.NotFoundException;
import com.caito.usuarioms.mapper.PersonaMapper;
import com.caito.usuarioms.mapper.PersonaNuevaMapper;
import com.caito.usuarioms.mapper.RolMapper;
import com.caito.usuarioms.mapper.UsuarioMapper;
import com.caito.usuarioms.repository.PersonaRepository;
import com.caito.usuarioms.repository.RolRepository;
import com.caito.usuarioms.repository.UsuarioRepository;
import com.caito.usuarioms.service.contracts.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  caito Vilas
 */

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaMapper personaMapper;
    @Autowired
    private PersonaNuevaMapper personaNuevaMapper;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private RolMapper rolMapper;


    @Override
    public UsuarioDTO create(UsuarioNuevoDTO dto) {
        log.info("iniciando servicio alta de usuario");
        log.info("validando parametros...");
        this.validarUsuario(dto);
        log.info("parametros OK");
        Usuario usuario = this.armarUsuario(dto);
        return usuarioMapper.usuarioToUsuarioDTO(usuarioRepository.save(usuario));
    }

    @Override
    public List<UsuarioDTO> getAll() {
        log.info("iniciando servicio buscar usuarios");
        log.info("buscar usuarios...");
        return usuarioMapper.usuarioListToUsuarioDTOList(usuarioRepository.findAll());
    }

    @Override
    public PageableResponseDTO<UsuarioDTO> getAllPaginado(int page, int size) {
        log.info("inicio servicio mostrar usuarios paginado");
        if (page <= 0){
            log.error(ErrorMsg.PAGE_GRATHER_ZERO);
            throw new BadRequestException(ErrorMsg.PAGE_GRATHER_ZERO);
        }
        log.info("buscando usuarios...");
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Usuario> u = usuarioRepository.findAll(pageable);
        List<UsuarioDTO> usuarios = usuarioMapper
                .usuarioListToUsuarioDTOList(u.getContent());
        PageableResponseDTO<UsuarioDTO> response = new PageableResponseDTO<>();
        response.setPage(u.getNumber() + 1);
        response.setResults(u.getTotalElements());
        response.setTotalPages(u.getTotalPages());
        response.setContent(usuarios);
        return response;
    }

    @Override
    public UsuarioDTO getById(Long id) {
        log.info("iniciando servicio buscar usuario por id");
        log.info("buscando usuario...");
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->{
            log.error(ErrorMsg.USER_NOT_FOUND);
            throw new NotFoundException(ErrorMsg.USER_NOT_FOUND);
        });
        return usuarioMapper.usuarioToUsuarioDTO(usuario);
    }

    @Override
    public void delteUser(Long id) {
        log.info("iniciando servicio eliminar usuario por id");
        log.info("buscando usuario...");
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->{
            log.error(ErrorMsg.USER_NOT_FOUND);
            throw new NotFoundException(ErrorMsg.USER_NOT_FOUND);
        });
        log.info("eliminando usuario...");
        usuarioRepository.deleteById(id);
    }


    private void validarUsuario(UsuarioNuevoDTO dto) {
        if (usuarioRepository.existsByUsername(dto.getUsername())){
            log.error(ErrorMsg.USER_USERNAME_EXISTS);
            throw new BadRequestException(ErrorMsg.USER_USERNAME_EXISTS);
        }
        if (personaRepository.existsByDni(dto.getPersona().getDni())){
            log.error(ErrorMsg.USER_DNI_EXISTS);
            throw new BadRequestException(ErrorMsg.USER_DNI_EXISTS);
        }
        if (personaRepository.existsByEmail(dto.getPersona().getEmail())){
            log.error(ErrorMsg.USER_EMAIL_EXISTS);
            throw new BadRequestException(ErrorMsg.USER_EMAIL_EXISTS);
        }
    }

    private Usuario armarUsuario(UsuarioNuevoDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setPersona(personaNuevaMapper.personaDTOToPersona(dto.getPersona()));
        Rol rol = rolRepository.findByRolName(dto.getRol()).orElseThrow(()->{
            log.error(ErrorMsg.ROL_NOT_FOUND);
            throw new NotFoundException(ErrorMsg.ROL_NOT_FOUND);
        });
        List<Rol> roles = new ArrayList<>();
        roles.add(rol);
        usuario.setRoles(roles);
        return usuario;
    }
}
