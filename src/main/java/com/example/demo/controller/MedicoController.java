package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SelectDTO;
import com.example.demo.model.Medico;
import com.example.demo.service.MedicoService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;

	@GetMapping("/select")
	public ResponseEntity<List<SelectDTO>> getMedicos() {
		return new ResponseEntity<List<SelectDTO>>(medicoService.getMedicos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id")
	public ResponseEntity<Optional<Medico>> getMedicosById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Medico>>(medicoService.getMedicoById(id), HttpStatus.OK);
	}
	
//	TODO: Paginação de medicos
//	@GetMapping()
//	public ResponseEntity<Page<Medico>> getMedicosPaginados(
//		@RequestParam("medico") long medico,
//		@RequestParam("data") String data,
//		@RequestParam("pagina") Pageable pagina
//	) {
//		return new ResponseEntity<Page<Medico>>(medicoService.getMedicosPaginados(pagina));
//	}
}
