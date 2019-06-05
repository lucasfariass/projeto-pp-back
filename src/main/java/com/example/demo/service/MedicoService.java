package com.example.demo.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SelectDTO;
import com.example.demo.model.Consultorio;
import com.example.demo.model.Medico;
import com.example.demo.repository.ConsultorioRepository;
import com.example.demo.repository.MedicoRepository;


@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private ConsultorioRepository consultarioRepository;
	
	public List<SelectDTO> getMedicos() {
		return medicoRepository.findAll()
				.stream()
				.map(this::mapperMedico)
				.collect(Collectors.toList());
	}
	
	public Optional<Medico> getMedicoById(Long id) {
		return medicoRepository.findById(id);
	}
	
	public Page<Medico> getMedicosPaginados(Pageable pageable) {
		return medicoRepository.findAll(pageable);
	}
	
	public Medico postMedico(Medico medico) {
		medico.setConsultorio(this.postConsultorio(medico.getConsultorio()));
		return medicoRepository.save(medico);
	}
	
	public Consultorio postConsultorio(Consultorio consultorio) {
		return consultarioRepository.save(consultorio);
	}
	
	private SelectDTO mapperMedico(Medico medico) {
		SelectDTO selectDto = new SelectDTO();
		
		selectDto.setId(medico.getId());
		selectDto.setNome(medico.getNome());
		
		return selectDto;
	}
	
}
