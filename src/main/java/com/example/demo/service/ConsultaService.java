package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Consulta;
import com.example.demo.repository.ConsultaRepository;
import com.example.demo.repository.MedicoRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;

	public Consulta postConsulta(Consulta consulta) {
		return consultaRepository.save(consulta);
	}
}
