package com.example.demo.service;

import com.example.demo.dto.ComidaDTO;
import com.example.demo.dto.ComidaRespuesta;
import com.example.demo.excepciones.AppException;
import com.example.demo.excepciones.RecursoNoEncontrado;
import com.example.demo.model.ComidaModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.ComidaRepository;
import com.example.demo.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ComidaServiceImp implements ComidaService {

  @Autowired
  private ComidaRepository comidaRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public ComidaDTO crearComida(long usuario_Id, ComidaDTO comidaDTO) {
    ComidaModel comidaModel = mapearEntidad(comidaDTO);

    UsuarioModel usuarioModel = usuarioRepository
        .findById(usuario_Id).orElseThrow(() -> new RecursoNoEncontrado("UsuarioModel", "id", usuario_Id));

    comidaModel.setUsuarioModel(usuarioModel);
    ComidaModel nuevaComida = comidaRepository.save(comidaModel);

    return mapearDTO(nuevaComida);
  }

  @Override
  public ComidaRespuesta mostrarTodasLasComidas(
      int numeroDePagina,
      int tamanoDePagina,
      String ordenarPorID,
      String sortDir) {
    Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
        ? Sort.by(ordenarPorID).ascending()
        : Sort.by(ordenarPorID).descending();
    Pageable pageable = PageRequest.of(numeroDePagina, tamanoDePagina, sort);

    Page<ComidaModel> comidas = comidaRepository.findAll(pageable);

    List<ComidaModel> listaComidas = comidas.getContent();
    List<ComidaDTO> contenido = listaComidas
        .stream()
        .map(comidaModel -> mapearDTO(comidaModel))
        .collect(Collectors.toList());

    ComidaRespuesta comidaRespuesta = new ComidaRespuesta();

    comidaRespuesta.setContenido(contenido);
    comidaRespuesta.setNumeroPagina(comidas.getNumber());
    comidaRespuesta.setMedidaPagina(comidas.getSize());
    comidaRespuesta.setTotalElementos(comidas.getTotalElements());
    comidaRespuesta.setTotalPaginas(comidas.getTotalPages());
    comidaRespuesta.setUltima(comidas.isLast());

    return comidaRespuesta;
  }

  @Override
  public void borrarComida(Long id) {
    ComidaModel comidaModel = comidaRepository
        .findById(id)
        .orElseThrow(() -> new RecursoNoEncontrado("ComidaModel", "id", id));

    comidaRepository.delete(comidaModel);
  }

  @Override
  public ComidaDTO obtenerComidaPorId(Long id) {
    ComidaModel comidaModel = comidaRepository
        .findById(id)
        .orElseThrow(() -> new RecursoNoEncontrado("ComidaModel", "id", id));

    return mapearDTO(comidaModel);
  }

  // Funcion que convierte model a DTO
  private ComidaDTO mapearDTO(ComidaModel comidaModel) {
    ComidaDTO comidaDTO = new ComidaDTO();

    comidaDTO.setId(comidaModel.getId());
    comidaDTO.setComida(comidaModel.getComida());
    comidaDTO.setGramos(comidaModel.getGramos());
    comidaDTO.setProteinas(comidaModel.getProteinas());
    comidaDTO.setCalorias(comidaModel.getCalorias());
    comidaDTO.setCarbohidratos(comidaModel.getCarbohidratos());

    return comidaDTO;
  }

  private ComidaModel mapearEntidad(ComidaDTO comidaDTO) {
    ComidaModel comidaModel = new ComidaModel();

    comidaModel.setComida(comidaDTO.getComida());
    comidaModel.setGramos(comidaDTO.getGramos());
    comidaModel.setProteinas(comidaDTO.getProteinas());
    comidaModel.setCalorias(comidaDTO.getCalorias());
    comidaModel.setCarbohidratos(comidaDTO.getCarbohidratos());

    return comidaModel;
  }

  @Override
  public List<ComidaDTO> obtenerComidasPorUsuarioId(long usuarioId) {
    List<ComidaModel> comidas = comidaRepository.findByUsuarioModelId(usuarioId);
    return comidas.stream().map(comidaModel -> mapearDTO(comidaModel)).collect(Collectors.toList());
  }

  @Override
  public ComidaDTO actualizarComida(Long usuarioId, Long comidaId, ComidaDTO solicitudComida) {
    UsuarioModel usuarioModel = usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new RecursoNoEncontrado("Usuario", "id", usuarioId));

    ComidaModel comidaModel = comidaRepository.findById(comidaId)
        .orElseThrow(() -> new RecursoNoEncontrado("Comida", "id", comidaId));

    if (!comidaModel.getUsuarioModel().getId().equals(usuarioModel.getId())) {
      throw new AppException(HttpStatus.BAD_REQUEST, "Esta comida no pertenece a tu usuario");
    }

    comidaModel.setComida(solicitudComida.getComida());
    comidaModel.setGramos(solicitudComida.getGramos());
    comidaModel.setProteinas(solicitudComida.getProteinas());
    comidaModel.setCalorias(solicitudComida.getCalorias());
    comidaModel.setCarbohidratos(solicitudComida.getCarbohidratos());

    ComidaModel comidaActualizada = comidaRepository.save(comidaModel);
    return mapearDTO(comidaActualizada);

  }

}
