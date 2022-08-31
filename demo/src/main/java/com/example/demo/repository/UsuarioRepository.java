package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    
    public UsuarioModel findByEmail(String email);
	
	public Optional<UsuarioModel> findByUsernameOrEmail(String username,String email);
	
	public UsuarioModel findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	public Boolean existsByEmail(String email);
	
}
