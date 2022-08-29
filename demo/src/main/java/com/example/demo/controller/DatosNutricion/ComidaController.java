package com.example.demo.controller.DatosNutricion;

import com.example.demo.dto.ComidaDTO;
import com.example.demo.dto.ComidaRespuesta;
import com.example.demo.service.ComidaService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ComidaController {

    @Autowired
    private ComidaService comidaService;

    @GetMapping("comidas")
    public ComidaRespuesta mostrarTodasLasComidas(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) int numeroDePagina,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int tamanoDePagina,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String ordenarPorID,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
        return comidaService.mostrarTodasLasComidas(numeroDePagina, tamanoDePagina, ordenarPorID, sortDir);
    }

    @GetMapping("/comida/{id}")
    public ResponseEntity<ComidaDTO> obtenerComdiaPorId(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(comidaService.obtenerComidaPorId(id));
    }

    @GetMapping("/usuario/{usuarioId}/comidas")
    public List<ComidaDTO> listarComidaPorUsuarioId(@PathVariable(value = "usuarioId") Long usuarioId) {
        return comidaService.obtenerComidasPorUsuarioId(usuarioId);
    }

    @PostMapping("/usuario/{usuarioId}/comida")
    public ResponseEntity<ComidaDTO> guardarComida(@PathVariable(value = "usuarioId") long usuario_Id,
            @RequestBody ComidaDTO comidaDTO) {
        return new ResponseEntity<>(comidaService.crearComida(usuario_Id, comidaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/usuario/{usuarioId}/comida/{id}")
    public ResponseEntity<ComidaDTO> actualizarComida(
            @Valid
            @PathVariable(value = "usuarioId") long usuarioId,
            @PathVariable(value = "id") Long comidaId,
            @RequestBody ComidaDTO comidaDTO) {
        ComidaDTO comidaActualizada = comidaService.actualizarComida(usuarioId, comidaId, comidaDTO);
        return new ResponseEntity<>(comidaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/comida/{id}")
    public ResponseEntity<String> borrarComida(
            @PathVariable(name = "id") Long id) {
        comidaService.borrarComida(id);
        return new ResponseEntity<>(
                "Dato comida eliminada con exito",
                HttpStatus.OK);
    }
}
