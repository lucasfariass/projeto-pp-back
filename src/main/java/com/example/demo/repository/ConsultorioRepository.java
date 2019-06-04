package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Consultorio;

public interface ConsultorioRepository  extends JpaRepository<Consultorio, Long> {

}
