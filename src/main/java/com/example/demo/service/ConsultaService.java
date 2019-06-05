package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ConsultaDTO;
import com.example.demo.dto.PaginadorDTO;
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
	
	public PaginadorDTO<Consulta> getConsultasPaginadas(Long idMedico, String data, Pageable page) {
		Page<Consulta> pagina = consultaRepository.findAll(ConsultaSpecification.byFilter(idMedico, data), page);
		PaginadorDTO<Consulta> paginador = new PaginadorDTO<Consulta>();
		paginador.setConteudo(pagina.getContent());
		paginador.setTotalRegistro(pagina.getTotalElements());
		
		return paginador;
	}
	
	public String deleteConsulta(Long id) {
		consultaRepository.deleteById(id);
		return "Consulta excluida";
	}
}
