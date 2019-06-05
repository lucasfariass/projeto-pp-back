package com.example.demo.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ConsultaDTO;
import com.example.demo.model.Consulta;
import com.example.demo.repository.ConsultaRepository;
import com.example.demo.repository.MedicoRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;

	public Consulta postConsulta(ConsultaDTO consulta) {
		Consulta consultaEntidade = new Consulta();
		consultaEntidade.setData(consulta.getData());
		consultaEntidade.setHora(consulta.getHora());
		consultaEntidade.setMedico(
				this.medicoRepository.findById(consulta.getIdMedico())
				.orElseThrow(() -> new EntityNotFoundException())
				);
		return consultaRepository.save(consultaEntidade);
	}
}
