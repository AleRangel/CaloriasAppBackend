package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UsuarioDTO;

public interface UsuarioService {

    // Crear un usuario
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);

    // Obtiene a todos los usuarios
    public List<UsuarioDTO> obtenerTodosLosUsuarios();

    // Obtiene a un usuario por id
    public UsuarioDTO obtenerUsuruarioPorId(Long id);

    //borrarUsuario
    public void borrarUsuario(Long id);

}
