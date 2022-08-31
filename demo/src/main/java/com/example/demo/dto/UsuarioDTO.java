package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UsuarioDTO {

    private Long id;
    
    @NotEmpty
    @Size(min = 5,message = "El nombre de Usuario debera tener mas de 5 caracteres")
    private String username;

    @NotEmpty(message = "El nombre no debe ser vacio o nulo")    
    private String nombre;

    @NotEmpty(message = "El email no debe ser vacio")
    @Email
    private String email;
    
    @NotEmpty(message = "El password no debe ser vacio")
    private String password;

    public UsuarioDTO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
