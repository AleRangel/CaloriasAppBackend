package com.example.demo.controller.DatosNutricion;

import com.example.demo.model.DatosNutricion;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buscar")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public class DatosNutricionModelController {

    @GetMapping("/{alimento}")
    public ArrayList buscarAlimento(@PathVariable String alimento) {
        DatosNutricion datosNutricion = new DatosNutricion(alimento);
        ArrayList<String> alimentos = new ArrayList<>();
        alimentos = datosNutricion.mandarDatos();
        return alimentos;
    }
}
