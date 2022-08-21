package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Usuario", unique = true, nullable = false)
    private String usuario;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ComidaModel> comidaModel = new HashSet<>();

    public UsuarioModel() {
        super();
    }

    public UsuarioModel(Long id, String usuario, String nombre, String email, String password) {
        super();
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;

    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Set<ComidaModel> return the comidaModel
     */
    public Set<ComidaModel> getComidaModel() {
        return comidaModel;
    }

    /**
     * @param comidaModel the comidaModel to set
     */
    public void setComidaModel(Set<ComidaModel> comidaModel) {
        this.comidaModel = comidaModel;
    }

}
