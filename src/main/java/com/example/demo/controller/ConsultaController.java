package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ConsultaDTO;
import com.example.demo.model.Consulta;
import com.example.demo.service.ConsultaService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;

	@PostMapping()
	public ResponseEntity<Consulta> postConsulta(@RequestBody ConsultaDTO consulta) {
		return new ResponseEntity<Consulta>(consultaService.postConsulta(consulta), HttpStatus.CREATED);
	}
}
