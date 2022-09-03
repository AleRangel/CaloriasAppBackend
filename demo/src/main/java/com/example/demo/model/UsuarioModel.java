package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;
    
    

    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL, orphanRemoval = true)    
    @JsonIgnore
    private Set<ComidaModel> comidaModel = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
	private Set<Rol> roles = new HashSet<>();



    
    public UsuarioModel() {
        super();
    }

    

    public UsuarioModel(Long id, String username, String nombre, String email, String password,
            Set<ComidaModel> comidaModel, Set<Rol> roles) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.comidaModel = comidaModel;
        this.roles = roles;
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

    public Set<ComidaModel> getComidaModel() {
        return comidaModel;
    }

    public void setComidaModel(Set<ComidaModel> comidaModel) {
        this.comidaModel = comidaModel;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }



    public boolean isAccountNonExpired() {
        return false;
    }



    public boolean isCredentialsNonExpired() {
        return false;
    }

    

    

}
