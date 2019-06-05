package com.example.demo.dto;

public class MedicoDTO {
	
	private Long id;
    private String nome;
    private String especialidade;
    private ConsultorioDTO consultorio;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public ConsultorioDTO getConsultorio() {
		return consultorio;
	}
	
	public void setConsultorio(ConsultorioDTO consultorio) {
		this.consultorio = consultorio;
	}
    
}
