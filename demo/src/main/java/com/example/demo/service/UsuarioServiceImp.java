package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.excepciones.RecursoNoEncontrado;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioModel = mapearEntidad(usuarioDTO);

        UsuarioModel nuevoUsuario = usuarioRepository.save(usuarioModel);

        UsuarioDTO usuarioRespuesta = mapearDTO(nuevoUsuario);

        return usuarioRespuesta;
    }

    @Override
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuarioModel -> mapearDTO(usuarioModel)).collect(Collectors.toList());

    }

    // Funcion que convierte model a DTO
    private UsuarioDTO mapearDTO(UsuarioModel usuarioModel) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuarioModel.getId());
        usuarioDTO.setUsuario(usuarioModel.getUsuario());
        usuarioDTO.setNombre(usuarioModel.getNombre());
        usuarioDTO.setEmail(usuarioModel.getEmail());
        usuarioDTO.setPassword(usuarioModel.getPassword());
        return usuarioDTO;
    }

    // Convierte DTO a Model
    private UsuarioModel mapearEntidad(UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setUsuario(usuarioDTO.getUsuario());
        usuarioModel.setNombre(usuarioDTO.getNombre());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setPassword(usuarioDTO.getPassword());

        return usuarioModel;

    }

    @Override
    public UsuarioDTO obtenerUsuruarioPorId(Long id) {
        UsuarioModel usuarioModel = usuarioRepository
                .findById(id).orElseThrow(() -> new RecursoNoEncontrado("UsuarioModel", "id", id));
        return mapearDTO(usuarioModel);
    }

}
