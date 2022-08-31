package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Rol;


public interface RolRepositorio extends JpaRepository<Rol, Long>{
    
    public Optional<Rol> findByNombre(String nombre);

}
