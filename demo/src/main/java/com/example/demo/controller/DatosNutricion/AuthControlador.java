package com.example.demo.controller.DatosNutricion;


import java.security.Principal;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Security.JWTAuthResonseDTO;
import com.example.demo.Security.JwtTokenProvider;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Rol;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.RolRepositorio;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
/* @CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET} ) */
public class AuthControlador {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private RolRepositorio rolRepositorio;

    
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @PostMapping("/iniciarSesion")    
    public ResponseEntity<JWTAuthResonseDTO> outhenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken
            (loginDTO.getUsernameOrEmail(), loginDTO.getPassword())
            );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //obtenemos el token del jwtToxenProvider
        String token = jwtTokenProvider.generarToken(authentication);

        return ResponseEntity.ok(new JWTAuthResonseDTO(token));
    }

    @PostMapping("/registro")
    public ResponseEntity<?> resgistrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        if (usuarioRepository.existsByUsername(usuarioDTO.getUsername())) {
            return new ResponseEntity<>("Ese nombre de usuario ya existe",HttpStatus.BAD_REQUEST);
        }
        if (usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            return new ResponseEntity<>("Ese email ya existe",HttpStatus.BAD_REQUEST);
        }

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNombre(usuarioDTO.getNombre());
        usuarioModel.setUsername(usuarioDTO.getUsername());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));

        Rol roles = rolRepositorio.findByNombre("ROLE_USER").get();
        usuarioModel.setRoles(Collections.singleton(roles));

        usuarioRepository.save(usuarioModel);
        return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.CREATED);
    }

    @GetMapping("/usuarioActual")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorEmail(Principal principal) {
        return ResponseEntity.ok(usuarioRepository.findByEmail(principal.getName()));
    }
}
    
