package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ComidaDTO;
import com.example.demo.dto.ComidaRespuesta;

public interface ComidaService {

    // Crear
    public ComidaDTO crearComida(long usuarioId, ComidaDTO comidaDTO);

    // Leer
    public ComidaRespuesta mostrarTodasLasComidas(int numeroDePagina, int tamanoDePagina, String ordenarPorID,
            String sortDir);

    public ComidaDTO obtenerComidaPorId(Long id);

    public List<ComidaDTO> obtenerComidasPorUsuarioId(long usuarioId);

    // Actualizar
    public ComidaDTO actualizarComida(Long usuarioId, Long comidaId, ComidaDTO solicitudComida);

    // Borrar
    public void borrarComida(Long id);

}