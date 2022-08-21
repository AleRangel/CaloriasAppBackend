package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ComidaModel;

public interface ComidaRepository extends JpaRepository<ComidaModel, Long> {

    public List<ComidaModel> findByUsuarioModelId(long usuarioId);

}
